package ir.realstresser;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.PlayerChatEvent;

@SuppressWarnings("unused") public class ChatListener {
    @Subscribe
    public void onChat(final PlayerChatEvent e) {
        if (Main.getPattern().matcher(e.getMessage()).matches())
            e.setResult(PlayerChatEvent.ChatResult.denied());
    }
}
