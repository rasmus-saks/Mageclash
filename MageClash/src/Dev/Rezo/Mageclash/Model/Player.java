package Dev.Rezo.Mageclash.Model;

import Dev.Rezo.Mageclash.Arena;
import com.badlogic.gdx.physics.box2d.*;

public class Player {
	//public Player(Arena arena) {
		
	//}
	public void create(float x, float y,short playerID,World world){
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.KinematicBody;
		bodyDef.position.set(x, y);
		Body body = world.createBody(bodyDef);

		CircleShape kinematicCircle = new CircleShape();
		kinematicCircle.setRadius(1f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = kinematicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.filter.groupIndex=playerID;

		PlayerEntity pEnt = new PlayerEntity();
		pEnt.body = body;
		body.setUserData(pEnt);
		kinematicCircle.dispose();
        
	}

}
