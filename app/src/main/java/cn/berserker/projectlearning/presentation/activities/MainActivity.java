package cn.berserker.projectlearning.presentation.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.berserker.projectlearning.R;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_LoadData)
    Button mLoadDataButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Timber.tag("LifeCycles");
        Timber.d("Activity Created");
    }

    @OnClick(R.id.btn_LoadData)
    public void onShowClick() {
        Toast.makeText(this, "btn_LoadData_OnClick", Toast.LENGTH_LONG).show();
    }

}
