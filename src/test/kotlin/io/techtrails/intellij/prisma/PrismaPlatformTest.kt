package io.techtrails.intellij.prisma

import com.intellij.openapi.util.SystemInfo
import io.mockk.*
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class PrismaPlatformTest {
    @Before
    fun beforeTests() {
        mockkObject(PrismaPlatform)
    }

    @After
    fun afterTests() {
        unmockkAll()
    }

    @Test fun `parseDistro extracts debian from ID=debian`() {
        assert(PrismaPlatform.parseDistro("ID=debian") == "debian")
    }

    @Test fun `parseDistro extracts debian from ID="debian"`() {
        assert(PrismaPlatform.parseDistro("ID=\"debian\"") == "debian")
    }

    @Test fun `parseDistro extracts debian from debian os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                PRETTY_NAME="Debian GNU/Linux 10 (buster)"
                NAME="Debian GNU/Linux"
                VERSION_ID="10"
                VERSION="10 (buster)"
                VERSION_CODENAME=buster
                ID=debian
            """.trimIndent()) == "debian"
        )
    }

    @Test fun `parseDistro extracts debian from Ubuntu os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="Ubuntu"
                VERSION="18.04.3 LTS (Bionic Beaver)"
                ID=ubuntu
                ID_LIKE=debian
                PRETTY_NAME="Ubuntu 18.04.3 LTS"
                VERSION_ID="18.04"
                VERSION_CODENAME=bionic
                UBUNTU_CODENAME=bionic
            """.trimIndent()) == "debian"
        )
    }

    @Test fun `parseDistro extracts rhel from Amazon Linux 1 os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="Amazon Linux AMI"
                VERSION="2018.03"
                ID="amzn"
                ID_LIKE="rhel fedora"
                VERSION_ID="2018.03"
                PRETTY_NAME="Amazon Linux AMI 2018.03"
                ANSI_COLOR="0;33"
                CPE_NAME="cpe:o:amazon:linux:2018.03:ga"
            """.trimIndent()) == "rhel"
        )
    }

    @Test fun `parseDistro extracts rhel from Amazon Linux 2 os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="Amazon Linux"
                VERSION="2"
                ID="amzn"
                ID_LIKE="centos rhel fedora"
                VERSION_ID="2"
                PRETTY_NAME="Amazon Linux 2"
                ANSI_COLOR="0;33"
                CPE_NAME="cpe:2.3:o:amazon:amazon_linux:2"
            """.trimIndent()) == "rhel"
        )
    }

    @Test fun `parseDistro extracts rhel from centos os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="CentOS Linux"
                VERSION="8 (Core)"
                ID="centos"
                ID_LIKE="rhel fedora"
                VERSION_ID="8"
                PLATFORM_ID="platform:el8"
            """.trimIndent()) == "rhel"
        )
    }

    @Test fun `parseDistro extracts rhel from fedora os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME=Fedora
                VERSION="31 (Container Image)"
                ID=fedora
                VERSION_ID=31
                VERSION_CODENAME=""
                PLATFORM_ID="platform:f31"
                PRETTY_NAME="Fedora 31 (Container Image)"
                ANSI_COLOR="0;34"
                LOGO=fedora-logo-icon
            """.trimIndent()) == "rhel"
        )
    }

    @Test fun `parseDistro extracts null from arch linux os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="Arch Linux"
                PRETTY_NAME="Arch Linux"
                ID=arch
                BUILD_ID=rolling
                ANSI_COLOR="0;36"
                LOGO=archlinux
            """.trimIndent()) == null
        )
    }

    @Test fun `parseDistro extracts debian from Linux Mint os-release`() {
        assert(
            PrismaPlatform.parseDistro("""
                NAME="Linux Mint"
                VERSION="18.2 (Sonya)"
                ID=linuxmint
                ID_LIKE=ubuntu
                PRETTY_NAME="Linux Mint 18.2"
                VERSION_ID="18.2"
                VERSION_CODENAME=sonya
                UBUNTU_CODENAME=xenial
            """.trimIndent()) == "debian"
        )
    }

    @Test fun `getOpenSSLVersion extracts v1-1-x from openssl command`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns "OpenSSL 1.1.0d  1 Feb 2014"

        assert(PrismaPlatform.getOpenSSLVersion() == "1.1.x")
    }

    @Test fun `getOpenSSLVersion extracts v1-0-x from openssl command`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns "OpenSSL 1.0.2g  1 Mar 2016"

        assert(PrismaPlatform.getOpenSSLVersion() == "1.0.x")
    }

    @Test fun `getOpenSSLVersion returns null on unrecognized openssl output`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns "LibreSSL 2.8.3"

        assert(PrismaPlatform.getOpenSSLVersion() == null)
    }

    @Test fun `getOpenSSLVersion extracts v1-1-x from libssl list`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns null

        every {
            PrismaPlatform.runCommand(any<String>(), null)
        } returns """
            -rw-r--r--   1 root  root      719 19 mai 00:56 libssl.so.1.1.0
        """.trimIndent()

        assert(PrismaPlatform.getOpenSSLVersion() == "1.1.x")
    }

    @Test fun `getOpenSSLVersion extracts v1-0-x from libssl list`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns null

        every {
            PrismaPlatform.runCommand(any<String>(), null)
        } returns """
            -rw-r--r--   1 root  root      719 19 mai 00:56 libssl.so.1.0.2
        """.trimIndent()

        assert(PrismaPlatform.getOpenSSLVersion() == "1.0.x")
    }

    @Test fun `getOpenSSLVersion returns null on empty libssl list`() {
        every {
            PrismaPlatform.runCommand("openssl version -v", null)
        } returns null

        every {
            PrismaPlatform.runCommand(any<String>(), null)
        } returns ""

        assert(PrismaPlatform.getOpenSSLVersion() == null)
    }
}