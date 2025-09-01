C0 LSP Client Plugin for Jetbrains IDEs

this should be at feature parity with the official VSCode plugin, let me know if there is something that I'm missing

**why**:
I dislike VSCode and I prefer a full-fledged IDE experience

**credits:**
Thanks to the team at CMU and beyond that worked on C0. This work is partially derivative off of the vscode lsp client repository.

**requirements**:
1. npm
   * on macos: type `brew install nvm` and set up nvm
   * on windows: https://github.com/coreybutler/nvm-windows/releases
   * on linux: https://github.com/nvm-sh/nvm
2. Jetbrains IDE (CLion recommended)


**to setup**:
1. install the plugin into your IDE by going to Plugins and selecting the Install Plugin from Disk option within the settings button at the top of the Plugins tab
2. type the following into your terminal in a folder separate from your project:

```bash
git clone https://github.com/cmu15122/c0-lsp-vscode
npm install
npm run compile
```

3. copy the absolute path of the `server/out/server.js` file in the cloned github repository and paste it into the `C0 Language Server server.js file location: ` text box accessible at Settings | Languages & Extensions | C0
4. restart CLion

This should be compatible with any themes you use, and syntax highlighting should adapt.