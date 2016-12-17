package rodriguez.diego.com.week6_sharepreferences;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME = "USER_NAME";
    public static final String PASSWORD = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        // EXAMPLE 1 : example of writing in preferences programmatically
        String username = "JoeDoe";
        String password = "Passw0rd";

        // Context.MODE_PRIVATE
        // Context.MODE_WORLD_READABLE
        // Context.MODE_WORLD_WRITEABLE
        // If you create a shared preferences file with MODE_WORLD_READABLE or MODE_WORLD_WRITEABLE,
        // then any other apps that know the file identifier can access your data.

        SharedPreferences credentialsToWrite =
                getSharedPreferences("Credentials", Context.MODE_PRIVATE);
        // if we do not provide the file name "Credentials" the preference file will be created
        // exclusively for the activity from where the getSharedPreferences is invoked
        // SharedPreferences credentialsToWrite = getSharedPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor prefEditor = credentialsToWrite.edit();
        prefEditor.putString(USER_NAME, username);
        prefEditor.putString(PASSWORD, password);
        prefEditor.commit();

        // EXAMPLE 1.1 : example of reading from preferences programmatically
        SharedPreferences retrievedCredentials = getSharedPreferences("Credentials", Context.MODE_PRIVATE);
        String user = retrievedCredentials.getString(USER_NAME, "");
        String pwd = retrievedCredentials.getString(PASSWORD, "");
        Toast.makeText(this, "user name = " + user + " password = " + pwd, Toast.LENGTH_LONG).show();


        // EXAMPLE 2 : Writing into a file
        try {
            FileOutputStream fos;
            String strFileContents = "Some text to write to the file.";
            // MODE_PRIVATE or Context.MODE_PRIVATE are the same because Context is superclass of whole Activity class hierarchy
            fos = openFileOutput("Lab6Filename.txt", MODE_PRIVATE);
            fos.write(strFileContents.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Writing more text in the same file
        try {
            FileOutputStream fos;
            String strFileContents = "More text to write to the file.";
            fos = openFileOutput("Lab6Filename.txt", MODE_APPEND);
            fos.write(strFileContents.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // EXAMPLE 3 : Reading froma file
        try {
            FileInputStream fis = openFileInput("Lab6Filename.txt");
            StringBuffer sBuffer = new StringBuffer();
            DataInputStream dataIO = new DataInputStream(fis);
            String strLine = null;
            while ((strLine = dataIO.readLine()) != null) {
                sBuffer.append(strLine);
            }
            dataIO.close();
            fis.close();
            Toast.makeText(this, "Content read from Lab6Filename.txt is: " + sBuffer, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // EXAMPLE 4 : writing to cache directory
        try {
            File pathCacheDir = getCacheDir();
            String strCacheFileName = "myCacheFile.cache";
            String strFileContents = "Some data for our file";
            File newCacheFile = new File(pathCacheDir, strCacheFileName);
            newCacheFile.createNewFile();
            FileOutputStream foCache = new FileOutputStream(newCacheFile.getAbsolutePath());
            foCache.write(strFileContents.getBytes());
            foCache.close();

            // before exiting the app is a good practice to delete cache files which are no longer needed
            newCacheFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        // EXAMPLE 6 : loading preferences from XML
        android.app.FragmentManager fm = getFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.add(R.id.mainView, new MyPreferenceFragment()).addToBackStack("pref").commit();



    }

    public void showDefaultPreference(View view) {
        // read the a preference value
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String editTextPref = defaultSharedPref.getString("editTextPref", null);
        Toast.makeText(this, "Default editTextPref = " + editTextPref, Toast.LENGTH_LONG).show();
    }


    public static class MyPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.mypreferences);
        }
    }


}
