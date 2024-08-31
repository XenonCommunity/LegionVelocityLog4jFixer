package ir.realstresser;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;

import java.util.regex.Pattern;

@Plugin(id = "log4j_fixer", name = "Log4JFixer", version = "1.0", description = "A custom plugin to fix log4j")
@SuppressWarnings("unused") public class Main {
    private final ProxyServer server;
    @Getter private final static Pattern pattern = Pattern.compile(".*\\$\\{[^}]*\\}.*");
    @Inject
    public Main(final ProxyServer server) {
        this.server = server;
    }
    @Subscribe
    public void onInit(final ProxyInitializeEvent e){
        server.getEventManager().register(this, new ChatListener());
    }
}
