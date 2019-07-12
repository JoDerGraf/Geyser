/*
 * Copyright (c) 2019 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.connector.plugin;

import lombok.Getter;
import org.geysermc.api.plugin.Plugin;
import org.geysermc.api.plugin.PluginManager;

import java.util.HashSet;
import java.util.Set;

public class GeyserPluginManager implements PluginManager {

    @Getter
    private GeyserPluginLoader loader;

    @Getter
    private Set<Plugin> plugins = new HashSet<Plugin>();

    public GeyserPluginManager(GeyserPluginLoader loader) {
        this.loader = loader;
    }

    public void loadPlugin(Plugin plugin) {
        loader.loadPlugin(plugin);
        plugins.add(plugin);
    }

    public void unloadPlugin(Plugin plugin) {
        plugins.remove(plugin);
    }

    public void enablePlugin(Plugin plugin) {
        loader.enablePlugin(plugin);
    }

    public void disablePlugin(Plugin plugin) {
        loader.disablePlugin(plugin);
    }

    public Set<Plugin> getPlugins() {
        return plugins;
    }
}