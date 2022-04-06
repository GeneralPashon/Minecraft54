package minecraft54.engine.particles;

import minecraft54.engine.graphics.TextureRegion;
import minecraft54.engine.maths.vectors.Vector3d;
import minecraft54.engine.maths.vectors.Vector3f;
import minecraft54.engine.physics.Velocity;
import minecraft54.engine.util.Color;

public class Particle{

    private final Vector3d position;
    private final Vector3f normal;
    private final Color color;
    private float width;
    private long spawnedTime;
    private final TextureRegion texture;
    private long liveTimeMillis;
    private final ParticleBehavior behavior;
    private final Velocity velocity;
    public float gravityVelocity;

    public Particle(TextureRegion texture,Vector3d position,long liveTimeMillis,float width,ParticleBehavior behavior){
        this.texture=texture;
        this.position=position;
        this.behavior=behavior;
        this.width=width;
        this.liveTimeMillis=liveTimeMillis;

        velocity=new Velocity();
        color=new Color();
        normal=new Vector3f();
    }

    public void setTexture(TextureRegion texture){
        this.texture.setTextureRegion(texture);
    }
    public TextureRegion getTexture(){
        return texture;
    }

    public Vector3d getPosition(){
        return position;
    }

    public Velocity getVelocity(){
        return velocity;
    }

    public Vector3f getNormal(){
        return normal;
    }

    public Color getColor(){
        return color;
    }

    public void setWidth(float width){
        this.width=width;
    }
    public float getWidth(){
        return width;
    }

    public void resetSpawnTime(){
        spawnedTime=System.currentTimeMillis();
    }
    public long getLiveTimeMillis(){
        return System.currentTimeMillis()-spawnedTime;
    }

    public void setLiveTime(long millis){
        liveTimeMillis=millis;
    }
    public long getLiveTime(){
        return liveTimeMillis;
    }

    public void updateBehavior(){
        behavior.update(this);
    }

}
