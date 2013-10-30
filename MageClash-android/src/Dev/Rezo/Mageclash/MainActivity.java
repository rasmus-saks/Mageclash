package Dev.Rezo.Mageclash;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        
        config.useAccelerometer = false;
        config.useCompass = false;
        config.useWakelock = false;
        config.useGL20 = true;
        
        initialize(new MageClashGame(), config);
    }
}