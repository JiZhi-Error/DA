package com.tencent.mm.plugin.teenmode.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class SettingsTeenModeMainOther extends MMActivity {
    private WeImageView FWR;
    private MMImageView FWS;
    private TextView jBR;
    private TextView jVO;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.brg;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(187450);
        super.onCreate(bundle);
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        this.FWR = (WeImageView) findViewById(R.id.dud);
        this.FWS = (MMImageView) findViewById(R.id.dhh);
        this.jVO = (TextView) findViewById(R.id.ir3);
        this.jBR = (TextView) findViewById(R.id.bn6);
        int intExtra = getIntent().getIntExtra("biz_type", 0);
        Log.i("MicroMsg.SettingsTeenModeMainOther", "type:%s", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 1:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_news));
                this.FWR.setIconColor(a.n(getContext(), R.color.Orange));
                this.jVO.setText(R.string.hm5);
                this.jBR.setText(R.string.blt);
                break;
            case 2:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_searchlogo));
                this.FWR.setIconColor(a.n(getContext(), R.color.Red));
                this.jVO.setText(R.string.hlx);
                this.jBR.setText(R.string.bln);
                break;
            case 3:
                this.FWR.setVisibility(8);
                this.FWS.setVisibility(0);
                this.jVO.setText(R.string.hlz);
                this.jBR.setText(R.string.blo);
                break;
            case 4:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_nearby));
                this.FWR.setIconColor(a.n(getContext(), R.color.Blue));
                this.jVO.setText(R.string.hm1);
                this.jBR.setText(R.string.blp);
                break;
            case 5:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_shake));
                this.FWR.setIconColor(a.n(getContext(), R.color.Blue));
                this.jVO.setText(R.string.hm3);
                this.jBR.setText(R.string.blr);
                break;
            case 6:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_shop));
                this.FWR.setIconColor(a.n(getContext(), R.color.Red));
                this.jVO.setText(R.string.hm4);
                this.jBR.setText(R.string.bls);
                break;
            case 7:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_wecoin_entrance));
                this.FWR.setIconColor(a.n(getContext(), R.color.Brand));
                this.jVO.setText(R.string.hm6);
                this.jBR.setText(R.string.blu);
                break;
            case 8:
                this.FWR.setImageDrawable(a.l(getContext(), R.raw.icons_outlined_live_nearby));
                this.FWR.setIconColor(a.n(getContext(), R.color.Blue));
                this.jVO.setText(R.string.hm2);
                this.jBR.setText(R.string.blq);
                break;
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.teenmode.ui.SettingsTeenModeMainOther.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(187449);
                SettingsTeenModeMainOther.this.onBackPressed();
                AppMethodBeat.o(187449);
                return true;
            }
        });
        AppMethodBeat.o(187450);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(187451);
        super.onPause();
        AppMethodBeat.o(187451);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(187452);
        super.onDestroy();
        AppMethodBeat.o(187452);
    }
}
