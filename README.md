# Prisma support for IntelliJ

This IntelliJ plugin aims to provide basic support for [Prisma's](https://prisma.io)
`.schema` files into Jetbrains IDEs.

## Features wishlist

- [X] Prisma icon on `.prisma` files
- [X] Syntax highlighting
- [X] Prisma-specific Color Scheme – being able to fine-tune syntax highlighting of Prisma-specific tokens
- [ ] Error highlighting
- [ ] Code formatter - *being able to automatically format a .prisma file*
- [ ] Line commenter – *being able to comment the current line via a keyboard shortcut*
- [ ] Code folding – *being able to fold/collapse blocks within the editor*
- [ ] Code structure view - *being able to see the file's structure in the Structure tool window*
- [ ] Usage finder - *being able to find usages of an entity*
- [ ] Reference resolution - *being able to navigate from an entity usage to its definition*
- [ ] Code completion - *being able to provide autocompleted keywords/entity names*
- [ ] Code style settings - *being able to configure `.prisma` code formatting styles*
- [ ] Line markers - *being able to navigate to related code from gutter markers*

## Implemented features

### Syntax Highlighting

Syntax Highlighting is tailored to the Schema Language tokens and allows you to fully
customize the file's rendering through a dedicated Color Settings page.

![Syntax Highlighting](../media/color-settings.gif?raw=true)

![Syntax Highlighting](../media/syntax-highlighting.png?raw=true)

## Contributing

You're more than welcome to open issues and submit PR to help me maintain & improve this plugin!

## License

Plugin released under the MIT license - see [LICENSE.md](https://github.com/olance/intellij-prisma/blob/master/LICENSE.md)

Prisma's icon is © Prisma