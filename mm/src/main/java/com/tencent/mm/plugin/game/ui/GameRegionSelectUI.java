package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.commlib.b;
import com.tencent.mm.plugin.game.e.a;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import java.util.Map;

public class GameRegionSelectUI extends MMPreference {
    private f screen;
    private GameRegionPreference.a xVD;
    private Map<String, GameRegionPreference.a> xVH;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42359);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(42359);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(42361);
        setMMTitle(R.string.ds_);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameRegionSelectUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42356);
                GameRegionSelectUI.this.setResult(0);
                GameRegionSelectUI.this.hideVKB();
                GameRegionSelectUI.this.finish();
                AppMethodBeat.o(42356);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.ds9), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.game.ui.GameRegionSelectUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42358);
                if (e.gg(GameRegionSelectUI.this)) {
                    h.a((Context) GameRegionSelectUI.this, true, GameRegionSelectUI.this.getString(R.string.ds7), "", GameRegionSelectUI.this.getString(R.string.ds8), GameRegionSelectUI.this.getString(R.string.ds6), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.GameRegionSelectUI.AnonymousClass2.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(42357);
                            e.gh(GameRegionSelectUI.this);
                            GameRegionSelectUI.a(GameRegionSelectUI.this);
                            Intent intent = new Intent();
                            GameRegionPreference.a fX = e.fX(GameRegionSelectUI.this);
                            if (fX != null) {
                                intent.putExtra("gameRegionName", e.a(fX));
                                GameRegionSelectUI.this.setResult(-1, intent);
                            } else {
                                GameRegionSelectUI.this.setResult(1);
                            }
                            GameRegionSelectUI.this.finish();
                            AppMethodBeat.o(42357);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.game.ui.GameRegionSelectUI.AnonymousClass2.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                } else {
                    GameRegionSelectUI.a(GameRegionSelectUI.this);
                    Intent intent = new Intent();
                    GameRegionPreference.a fX = e.fX(GameRegionSelectUI.this);
                    if (fX != null) {
                        intent.putExtra("gameRegionName", e.a(fX));
                        GameRegionSelectUI.this.setResult(-1, intent);
                    } else {
                        GameRegionSelectUI.this.setResult(1);
                    }
                    GameRegionSelectUI.this.finish();
                }
                AppMethodBeat.o(42358);
                return true;
            }
        }, null, t.b.GREEN);
        this.screen.removeAll();
        this.xVH = a.C1396a.xYZ.dWN();
        GameRegionPreference.a fX = e.fX(this);
        if (fX != null) {
            fX.isSelected = true;
        }
        for (GameRegionPreference.a aVar : this.xVH.values()) {
            if (aVar != null) {
                GameRegionPreference gameRegionPreference = new GameRegionPreference(this);
                if (aVar == null || Util.isNullOrNil(aVar.fuO)) {
                    Log.e("MicroMsg.GameRegionPreference", "setData region error");
                } else {
                    gameRegionPreference.xVD = aVar;
                    gameRegionPreference.setKey(aVar.fuO);
                }
                if (aVar.isDefault) {
                    this.screen.a(gameRegionPreference, 0);
                } else {
                    this.screen.c(gameRegionPreference);
                }
            }
        }
        this.screen.c(new PreferenceCategory(this));
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(42361);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(42362);
        if (preference instanceof GameRegionPreference) {
            GameRegionPreference.a aVar = ((GameRegionPreference) preference).xVD;
            if (aVar == null) {
                AppMethodBeat.o(42362);
                return false;
            }
            this.xVD = aVar;
            for (GameRegionPreference.a aVar2 : this.xVH.values()) {
                aVar2.isSelected = false;
            }
            aVar.isSelected = true;
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(42362);
            return true;
        }
        AppMethodBeat.o(42362);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(42360);
        a.C1396a.xYZ.dWL();
        super.onDestroy();
        AppMethodBeat.o(42360);
    }

    static /* synthetic */ void a(GameRegionSelectUI gameRegionSelectUI) {
        AppMethodBeat.i(42363);
        if (gameRegionSelectUI.xVD != null) {
            e.aM(gameRegionSelectUI, gameRegionSelectUI.xVD.fuO);
            a.C1396a.xYZ.xYX = true;
            b.dTd().I(true, 7);
        }
        AppMethodBeat.o(42363);
    }
}
