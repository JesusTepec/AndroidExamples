package com.example.jesustepec.formulariodinamico;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.RotateUpTransformer;
import com.example.jesustepec.formulariodinamico.Data.DataFragments;
import com.example.jesustepec.formulariodinamico.Fragments.ConfiguracionesFragment;
import com.example.jesustepec.formulariodinamico.Fragments.InstruccionesFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new SeccionesPageAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.setPageTransformer(true, new RotateUpTransformer());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.secciones_tabLayout);
        tabLayout.setupWithViewPager(vpPager);


    }

    public  class SeccionesPageAdapter extends FragmentPagerAdapter {
        private ArrayList<DataFragments> menu = new ArrayList<>();

        SeccionesPageAdapter(FragmentManager fragmentManager){
            super(fragmentManager);

            menu.add(new DataFragments("Configuraciones", 0, new ConfiguracionesFragment()));
            menu.add(new DataFragments("Instrucciones", 0, new InstruccionesFragment()));
        }


        @Override
        public Fragment getItem(int position) {
           return menu.get(position).getFragmento();
        }

        @Override
        public int getCount() {
            return menu.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return menu.get(position).getTitulo();
        }
    }

}
