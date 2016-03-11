package balades.tps16balladessonores;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import balades.tps16balladessonores.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements MapFragment.OnFragmentInteractionListener, ListBalladesFragment.OnListFragmentInteractionListener {
    private static final String TAG = "MainActivity";
    Fragment [] balladesFrags = new Fragment [2] ;
    BalladesFragsPagerAdapter balladesFragsPagerAdapter;
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        balladesFrags[0] = MapFragment.newInstance("Test1", "Test2");
        balladesFrags[1] = ListBalladesFragment.newInstance(1);
        setContentView(R.layout.activity_main); // ViewPager and its adapters use support library fragments, so use getSupportFragmentManager.
        balladesFragsPagerAdapter = new BalladesFragsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(balladesFragsPagerAdapter);
    }
    @Override
    public void onFragmentInteraction(String str) {}

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d(TAG, "List elt selected") ;
    }

    /**
     * PagerAdapter
     */
    public class BalladesFragsPagerAdapter extends FragmentStatePagerAdapter {
        public BalladesFragsPagerAdapter(FragmentManager fm) {
             super(fm);
         }

        @Override
        public Fragment getItem(int i) {return balladesFrags[i];}

        @Override
        public int getCount() {return balladesFrags.length ;}

        @Override
        public CharSequence getPageTitle(int position) {return "OBJECT " + (position + 1);}
    }
}