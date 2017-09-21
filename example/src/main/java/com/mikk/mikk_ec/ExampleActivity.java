package com.mikk.mikk_ec;

import com.mikk.mikk.activities.ProxyActivity;
import com.mikk.mikk.delegates.MikkDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public MikkDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
