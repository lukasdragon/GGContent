package net.ggcontent.mod.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * @author Master801
 */
@SideOnly(Side.CLIENT)
public class CapeHelper {

	private static final List<String> usernameList = new ArrayList<String>();
	private static final String capeURL = "https://dl.dropboxusercontent.com/s/1rdi9mbed3f56lk/CapeURLs.txt"; //I dont know if I need this still!

	

	
	public static void addCapeToPlayer(String username, String customURL, AbstractClientPlayer player) {
		
		if (username == null) {
			
		} else {			
			
				if (customURL == null) {
					
				} else {
					URL url = null;
					InputStream stream = null;
					try {
						url = new URL(customURL);
						stream = (InputStream)url.openStream();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					if (stream == null) {
						
					} else {
						//Minecraft.getMinecraft().getTextureManager().loadTexture(new ResourceLocation("cloaks/" + username), (ITextureObject) new ThreadDownloadImageData(null, customURL, null, null));
						AbstractClientPlayer.func_152121_a(Type.CAPE, Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("cloaks/" + player.instance.getGameProfile().getName(), new DynamicTexture(ImageIO.read(new URL( customURL ).openStream()))));
					}
				}				
		
			}
		}
	

	private static final String getDefaultCapeURL() throws IOException {
		final URL url = new URL(capeURL);
		final InputStream stream = (InputStream)url.openStream();
		if (stream == null) {
			
			return null;
		}
		final Scanner scanner = new Scanner(stream);
		String defaultURL = null;
		if (scanner.hasNextLine()) {
			defaultURL = scanner.nextLine();
		}
		scanner.close();
		return defaultURL;
	}
	

}