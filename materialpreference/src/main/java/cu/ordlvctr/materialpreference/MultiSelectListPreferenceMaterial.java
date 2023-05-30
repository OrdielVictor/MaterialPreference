package cu.ordlvctr.materialpreference;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.MultiSelectListPreference;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiSelectListPreferenceMaterial extends MultiSelectListPreference {
	
	private Set<String> values = new HashSet();
	
	public MultiSelectListPreferenceMaterial(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onClick() {
		AlertDialog.Builder builder = new MaterialAlertDialogBuilder(getContext());
		builder.setTitle(getDialogTitle());
		final CharSequence[] entries = getEntries();
		final CharSequence[] entryValues = getEntryValues();
		final boolean[] checkedItems = getSelectedItems();
		builder.setMultiChoiceItems(entries, checkedItems, (dlg, which, isChecked) -> {
			if (isChecked)
				values.add(entryValues[which].toString());
			else
				values.remove(entryValues[which].toString());
			if (callChangeListener(values)) {
				setValues(values);
			}
		});
		builder.setPositiveButton(android.R.string.ok, null);
		builder.show();
	}
}
