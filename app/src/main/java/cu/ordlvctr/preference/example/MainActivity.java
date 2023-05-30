package cu.ordlvctr.preference.example;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.itsaky.androidide.logsender.LogSender;

import cu.ordlvctr.preference.example.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

	private ActivityMainBinding binding;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		LogSender.startLogging(this);
        super.onCreate(savedInstanceState);
		binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
		
		getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.frameLayout, new SettingsFragment())
			.commit();
    }
	
	public static class SettingsFragment extends PreferenceFragmentCompat {
		
		@Override
		public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
			setPreferencesFromResource(R.xml.preferences, rootKey);
		}
	}
}
