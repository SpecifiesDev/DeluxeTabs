# DeluxeTabs
DeluxeTabs is an open sourced Spigot plugin. It allows players with the proper permissions the ability to set their in game tab prefix. It is designed to be intuitive, and easy to configure the way you want it to be.
Spigot link: (insert)
# Information
As of right now there are 22 customizable name tags. You can set them to whatever you would like in the prefix.yml file. You can also set the command and gui prefixes in config.yml.
# Commands
```yml
/tabprefix
    Upon execution of this command a GUI is openened, allowing them to click on nametags that have corresponding values from prefixes.yml.
/setprefix
    Allows the console, or a player with appropriate permissions, to manually set a player's default prefix.
/clearprefix
    Allows the console, or a player with appropriate permissions, to manually clear a player's default prefix.
```
# Permissions
```yml
permissions:
    deluxetabs.prefix.#
        Give players access to the specific number of a nametag in /tabprefix.
    deluxetabs.customprefix
        If you want players to be able to have custom prefixes(/tabprefix), you have to give them this permission node.
    deluxetabs.onjoin
        If a player doesn't have a custom prefix enabled, it will default to their rank's prefix.
    deluxetabs.tabprefix
        Allows access to the tabprefix GUI.
    deluxetabs.setprefix
        Allows a player to manually set the prefix of a player.
    deluxetabs.clearprefix
        Allows a player to manually clear the prefix of a player.
```
# Dependencies
```java
[Dependencies]: Vault, A group management plugin
```
