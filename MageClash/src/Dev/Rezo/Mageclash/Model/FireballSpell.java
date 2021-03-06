package Dev.Rezo.Mageclash.Model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import Dev.Rezo.Mageclash.Model.SpellInfo;
public class FireballSpell extends Spell{
	static float SPEED = 4f;

	@Override
	public void fire(SpellInfo spellinfo) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(spellinfo.playerposition.x+spellinfo.firedirection.x, spellinfo.playerposition.y+spellinfo.firedirection.y);
		Body body = spellinfo.arena.world.createBody(bodyDef);

		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(0.5f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 1.0f;
		fixtureDef.filter.groupIndex = spellinfo.playerID;
		body.createFixture(fixtureDef);

		FireballEntity fEnt = new FireballEntity();
		fEnt.body = body;
		body.setLinearVelocity(spellinfo.firedirection.scl(SPEED));
		body.setUserData(fEnt);
		dynamicCircle.dispose();
		
	}

	@Override
	public void fireElite(SpellInfo spellinfo) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(spellinfo.playerposition.x+spellinfo.firedirection.x, spellinfo.playerposition.y+spellinfo.firedirection.y);
		Body body = spellinfo.arena.world.createBody(bodyDef);

		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(1f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.filter.groupIndex = spellinfo.playerID;
		

		FireballEliteEntity fEEnt = new FireballEliteEntity();
		fEEnt.body = body;
		body.setLinearVelocity(spellinfo.firedirection.scl(SPEED));
		body.setUserData(fEEnt);
		dynamicCircle.dispose();
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "It's a ball of fire, hurr durr. ELITE: Explodes on impact dealing some extra damage. The fireball also detonates when it hits a wall, meaning it can miss but still deal damage.";
	}

}
