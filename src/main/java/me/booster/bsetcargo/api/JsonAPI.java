package me.booster.bsetcargo.api;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class JsonAPI {

    @SuppressWarnings("all")
    public static void sendCommandText(Player p, String text, String mousetext, String command) {
        TextComponent texto = new TextComponent(text);
        BaseComponent[] textos = (new ComponentBuilder(mousetext)).create();
        HoverEvent passarOMouser = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                textos);
        texto.setHoverEvent(passarOMouser);
        ClickEvent clicar = new ClickEvent(ClickEvent.Action.RUN_COMMAND, command);
        texto.setClickEvent(clicar);
        p.spigot().sendMessage((BaseComponent)texto);
    }

    @SuppressWarnings("all")
    public static void sendText(Player p, String text, String mousetext) {
        TextComponent texto = new TextComponent(text);
        BaseComponent[] textos = (new ComponentBuilder(mousetext)).create();
        HoverEvent passarOMouser = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                textos);
        texto.setHoverEvent(passarOMouser);
        p.spigot().sendMessage((BaseComponent)texto);
    }

    @SuppressWarnings("all")
    public static void sendURL(Player p, String text, String mousetext, String url) {
        TextComponent texto = new TextComponent(text);
        BaseComponent[] textos = (new ComponentBuilder(mousetext)).create();
        HoverEvent passarOMouser = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                textos);
        texto.setHoverEvent(passarOMouser);
        texto.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
        p.spigot().sendMessage((BaseComponent)texto);
    }
}
