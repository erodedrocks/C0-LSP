C0 LSP Client Plugin for Jetbrains IDEs

**credits:**
Thanks to the team at CMU and beyond that worked on C0. This work is partially derivative off of the vscode lsp client repository.

**requirements**:
1. npm
   1. on macos: type `brew install nvm` and set up nvm
   2. on windows: https://github.com/coreybutler/nvm-windows/releases
   3. on linux: https://github.com/nvm-sh/nvm
2. Jetbrains IDE (CLion recommended)


**to setup**:
1. type the following into your terminal in a folder separate from your project:

```bash
git clone https://github.com/cmu15122/c0-lsp-vscode
npm install
npm run compile
```

2. copy the absolute path of the `server/out/server.js` file in the cloned github repository and paste it into the `C0 Language Server server.js file location: ` text box, accessible at Settings | Languages & Extensions | C0
3. Restart CLion