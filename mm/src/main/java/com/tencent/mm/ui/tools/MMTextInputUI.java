package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t;

public class MMTextInputUI extends MMActivity {
    private TextView Qvd;
    private int Qve;
    private int Qvf;
    private boolean Qvg;
    private int maxCount;
    private EditText vy;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(MMTextInputUI mMTextInputUI) {
        AppMethodBeat.i(143191);
        mMTextInputUI.goBack();
        AppMethodBeat.o(143191);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aw1;
    }

    private void goBack() {
        AppMethodBeat.i(143185);
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            h.a(getContext(), getString(R.string.fsv), "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.tools.MMTextInputUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(143181);
                    MMTextInputUI.this.hideVKB();
                    MMTextInputUI.this.setResult(0);
                    MMTextInputUI.this.finish();
                    AppMethodBeat.o(143181);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(143185);
            return;
        }
        hideVKB();
        setResult(0);
        finish();
        AppMethodBeat.o(143185);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(143186);
        if (4 == i2) {
            Log.i("MicroMsg.MMTextInputUI", "on back key down");
            goBack();
            AppMethodBeat.o(143186);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(143186);
        return onKeyDown;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(143187);
        super.onCreate(bundle);
        this.vy = (EditText) findViewById(R.id.ik7);
        this.Qvd = (TextView) findViewById(R.id.i50);
        this.vy.setHint(Util.nullAs(getIntent().getStringExtra("key_hint"), ""));
        this.vy.append(Util.nullAs(getIntent().getStringExtra("key_value"), ""));
        this.maxCount = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.Qvf = 0;
        this.Qve = Math.max(this.maxCount - 120, (this.maxCount * 9) / 10);
        this.Qvg = getIntent().getBooleanExtra("key_nullable", false);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.MMTextInputUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(143182);
                MMTextInputUI.a(MMTextInputUI.this);
                AppMethodBeat.o(143182);
                return false;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.tools.MMTextInputUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(143183);
                MMTextInputUI.this.O(MMTextInputUI.this.vy.getText());
                Intent intent = new Intent();
                intent.putExtra("key_result", MMTextInputUI.this.vy.getText());
                MMTextInputUI.this.setResult(-1, intent);
                MMTextInputUI.this.finish();
                AppMethodBeat.o(143183);
                return true;
            }
        }, null, t.b.GREEN);
        enableOptionMenu(this.Qvg);
        if (!this.Qvg || this.maxCount > 0) {
            this.vy.addTextChangedListener(new TextWatcher() {
                /* class com.tencent.mm.ui.tools.MMTextInputUI.AnonymousClass4 */

                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean z = false;
                    AppMethodBeat.i(143184);
                    String obj = editable.toString();
                    if (!MMTextInputUI.this.Qvg) {
                        if (obj.trim().length() > 0) {
                            MMTextInputUI.this.enableOptionMenu(true);
                        } else {
                            MMTextInputUI.this.enableOptionMenu(false);
                        }
                    }
                    if (MMTextInputUI.this.maxCount > 0) {
                        MMTextInputUI.this.Qvf = 0;
                        for (int i2 = 0; i2 < obj.length(); i2++) {
                            if (Util.isChinese(obj.charAt(i2))) {
                                MMTextInputUI.this.Qvf += 2;
                            } else {
                                MMTextInputUI.this.Qvf++;
                            }
                        }
                        if (MMTextInputUI.this.Qvf >= MMTextInputUI.this.Qve && MMTextInputUI.this.Qvf <= MMTextInputUI.this.maxCount) {
                            MMTextInputUI.this.enableOptionMenu(true);
                            MMTextInputUI.this.Qvd.setVisibility(0);
                            MMTextInputUI.this.Qvd.setTextColor(MMTextInputUI.this.getResources().getColor(R.color.ab_));
                            MMTextInputUI.this.Qvd.setText(MMTextInputUI.this.getString(R.string.hn1, new Object[]{Integer.valueOf((MMTextInputUI.this.maxCount - MMTextInputUI.this.Qvf) >> 1)}));
                            AppMethodBeat.o(143184);
                            return;
                        } else if (MMTextInputUI.this.Qvf > MMTextInputUI.this.maxCount) {
                            MMTextInputUI.this.enableOptionMenu(false);
                            MMTextInputUI.this.Qvd.setVisibility(0);
                            MMTextInputUI.this.Qvd.setTextColor(MMTextInputUI.this.getResources().getColor(R.color.aba));
                            MMTextInputUI.this.Qvd.setText(MMTextInputUI.this.getString(R.string.hn2, new Object[]{Integer.valueOf(((MMTextInputUI.this.Qvf - MMTextInputUI.this.maxCount) >> 1) + 1)}));
                            AppMethodBeat.o(143184);
                            return;
                        } else {
                            MMTextInputUI mMTextInputUI = MMTextInputUI.this;
                            if (MMTextInputUI.this.Qvg) {
                                z = true;
                            } else if (MMTextInputUI.this.Qvf > 0) {
                                z = true;
                            }
                            mMTextInputUI.enableOptionMenu(z);
                            MMTextInputUI.this.Qvd.setVisibility(8);
                        }
                    }
                    AppMethodBeat.o(143184);
                }
            });
        }
        AppMethodBeat.o(143187);
    }

    /* access modifiers changed from: protected */
    public void O(CharSequence charSequence) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(143188);
        super.onDestroy();
        AppMethodBeat.o(143188);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(143189);
        super.onResume();
        AppMethodBeat.o(143189);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(143190);
        super.onPause();
        AppMethodBeat.o(143190);
    }
}
