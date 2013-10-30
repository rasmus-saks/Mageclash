package dev.rezo.mageclash.core.Model;
import com.badlogic.gdx.graphics.Color;

import dev.rezo.mageclash.core.ArenaRenderer;

public class FireballEntity extends Entity {

	@Override
	public void render(ArenaRenderer renderer) {
		renderer.debugRenderer.setColor(new Color(1, 0, 0, 1));
		renderer.debugRenderer.circle(body.getPosition().x,body.getPosition().y,1f, 20);
		
	}
	public void onHit() {
	}

}