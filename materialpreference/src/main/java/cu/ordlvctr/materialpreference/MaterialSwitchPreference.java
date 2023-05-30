package cu.ordlvctr.materialpreference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.SwitchPreferenceCompat;

import cu.ordlvctr.materialpreference.R;

public class MaterialSwitchPreference extends SwitchPreferenceCompat {
	
	public MaterialSwitchPreference(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		
		setWidgetLayoutResource(R.layout.preference_widget_material_switch);
	}
}
