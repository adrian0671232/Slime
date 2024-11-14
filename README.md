# Slime

[![](https://jitpack.io/v/adrian0671232/Slime.svg)](https://jitpack.io/#adrian0671232/Slime)

Personal API that just has utilities that I (mostly) use for every plugin.

If you want to use this, then use jitpack.
You will also need to declare this in your main class.
Feel free to use this any way you'd like, or fork it and add more things you'd like.

Most things are self-explanatory.

An example usage:

## Main class

```java
Slime slime;

@Override
public void onEnable() {
    slime = new Slime();
}

public void getSlime() {
    return slime;
}
```

## Example class

```java

public void sendMessage(Player player, String message) {
    player.sendMessage(Main.getSlime().CC.translate(message));
}

```