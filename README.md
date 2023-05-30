<p align="center">
    <img src="./images/icon.png" width="80" height="80">
</p>

<h1 align="center">MaterialPreference</h1>
<p align="center">Una biblioteca para la creación de preferencias personalizadas con estilo MaterialYou</p><br>

<p align="center">
<!-- Jitpack -->
<img alt="jitpack" src="https://jitpack.io/v/OrdielVictor/MaterialPreference.svg">
<!-- Plataform -->
<img alt="plataform" src="https://img.shields.io/badge/OS-Android-brightgreen">
<!-- License -->
<img alt="license" src="https://img.shields.io/badge/License-GPLv3-blue.svg">
</p>
<br>

## Configurar
<strong>Paso 1.</strong> Agregue el repositorio de JitPack a su archivo de compilación<br>
Agréguelo en su raíz build.gradle al final de los repositorios:
```gradle
allprojects {
    repositories {
        maven { url "https://www.jitpack.io" }
    }
}
```
<strong>Paso 2.</strong> Agrega la dependencia
```gradle
dependencies {
    implementation 'com.github.OrdielVictor:MaterialPreference:1.0.0'
}
```
<br>

## Características
- MaterialSwitchPreference.
    - Solo si usas (`Theme.Material3`) a partir de la versión (`1.7.0`) de la biblioteca Material de Google.
- ListPreferenceMaterial.
- MultiSelectListPreferenceMaterial.
- EditTextPreferenceMaterial
<br>

## Uso
<p>Aquí hay una <a href="https://github.com/OrdielVictor/MaterialPreference/tree/main/app/src/main">muestra</a> de como usar la biblioteca de forma más avazanda.</p>

### MaterialSwitchPreference
``` xml
<cu.ordlvctr.materialpreference.SwitchMaterialPreference
    android:key="@string/material_switch_preference_key"
    android:title="@string/material_switch_preference_title"
    android:summary="@string/material_switch_preference_summary"
    android:defaultValue="false"/>
```

### ListPreferenceMaterial
``` xml
<cu.ordlvctr.materialpreference.ListPreferenceMaterial
    android:key="@string/list_preference_material_key"
    android:title="@string/list_preference_material_title"
    android:summary="@string/list_preference_material_summary"
    android:dialogTitle="@string/list_preference_material_dialogTitle"
    android:entries="@array/list_preference_material_entries"
    android:entryValues="@array/list_preference_material_entryValues"
    android:defaultValue="@string/list_preference_material_defaultValue"/>
```

### MultiSelectListPreferenceMaterial
```xml
<cu.ordlvctr.materialpreference.MultiSelectListPreferenceMaterial
    android:key="@string/multi_select_list_preference_material_key"
    android:title="@string/multi_select_list_preference_material_title"
    android:summary="@string/multi_select_list_preference_material_summary"
    android:dialogTitle="@string/multi_select_list_preference_dialogTitle"
    android:entries="@array/multi_select_list_preference_materialentries"
    android:entryValues="@array/multi_select_list_preference_material_entryValues"
    android:defaultValue="@array/multi_select_list_preference_material_defaultValues"/>
```

### EditTextPreferenceMaterialDialog
```xml
<cu.ordlvctr.materialpreference.SwitchMaterialPreference
    android:key="@string/edit_text_preference_material_dialog_key"
    android:title="@string/edit_text_preference_material_dialog_title"
    android:summary="@string/edit_text_preference_material_dialog_summary"
    android:dialogTitle="@string/edit_text_preference_material_dialog_dialogTitle"
    android:hint="@string/edit_text_preference_material_dialog_hint"/>
```

### EditTextPreferenceMaterial
```xml
<cu.ordlvctr.materialpreference.SwitchMaterialPreference
    android:key="@string/edit_text_preference_material_key"
    android:title="@string/edit_text_preference_material_title"
    android:summary="@string/edit_text_preference_material_summary"
    android:dialogTitle="@string/edit_text_preference_material_dialogTitle"
    android:hint="@string/edit_text_preference_material_hint"/>
```