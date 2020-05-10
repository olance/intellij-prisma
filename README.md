# Prisma support for IntelliJ

This IntelliJ plugin aims to provide basic support for [Prisma's](https://prisma.io)
`.schema` files into Jetbrains IDEs.

## Features wishlist

- [X] Prisma icon on `.prisma` files
- [X] Syntax highlighting
- [ ] Prisma-specific Color Scheme – being able to fine-tune syntax highlighting of Prisma-specific tokens
- [ ] Line commenter – *being able to comment the current line via a keyboard shortcut*
- [ ] Code folding – *being able to fold/collapse blocks within the editor*
- [ ] Code structure view - *being able to see the file's structure in the Structure tool window*
- [ ] Code formatter - *being able to automatically format a .prisma file*
- [ ] Usage finder - *being able to find usages of an entity*
- [ ] Reference resolution - *being able to navigate from an entity usage to its definition*
- [ ] Code completion - *being able to provide autocompleted keywords/entity names*
- [ ] Code style settings - *being able to configure `.prisma` code formatting styles*
- [ ] Line markers - *being able to navigate to related code from gutter markers*

## Implemented features

### Syntax Highlighting

As it is, the plugin provides some syntax highlighting.
However it's pretty basic, as it tries to map all tokens from the Prisma Lexer to existing, 
default Color Scheme types provided by the Jetbrains IDE.

As soon as a Prisma-specific Color Scheme is implemented, things will get much better and 
should allow finer-grained highlighting of the different elements of Prisma schemas.

![Syntax Highlighting](../media/syntax-highlighting.jpeg?raw=true)

## License

Plugin released under the MIT license - see [LICENSE.md](https://github.com/olance/intellij-prisma/blob/master/LICENSE.md)

Prisma's icon is © Prisma