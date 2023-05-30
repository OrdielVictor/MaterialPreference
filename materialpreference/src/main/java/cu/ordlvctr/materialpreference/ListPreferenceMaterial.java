package cu.ordlvctr.materialpreference;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.ListPreference;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ListPreferenceMaterial extends ListPreference {
	
	public ListPreferenceMaterial(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onClick() {
		AlertDialog.Builder builder = new MaterialAlertDialogBuilder(getContext());
		builder.setTitle(getDialogTitle());
		final CharSequence[] entries = getEntries();
		final CharSequence[] entryValues = getEntryValues();
		final int selected = findIndexOfValue(getValue());
		builder.setSingleChoiceItems(entries, selected, (dlg, which) -> {
			String value = (String) entryValues[which];
			if (callChangeListener(value)) {
				setValue(value);
			}
			dlg.dismiss();
		});
		builder.setNegativeButton(android.R.string.cancel, null);
		builder.show();
	}
}
