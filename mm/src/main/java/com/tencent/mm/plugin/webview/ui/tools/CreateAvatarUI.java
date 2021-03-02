package com.tencent.mm.plugin.webview.ui.tools;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.gallery.picker.view.ImageCropUI;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.webview.k.c;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.protocal.protobuf.co;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public class CreateAvatarUI extends MMActivity implements i, c.a {
    private InputMethodManager JdP;
    private EditText JdQ;
    private String JdR;
    private boolean JdS = true;
    private boolean JdT = false;
    private volatile com.tencent.mm.plugin.webview.k.c JdU;
    private String JdV;
    private boolean JdW = false;
    private long JdX = 0;
    private long JdY = 0;
    private String appId;
    private String fileId;
    private q gxX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79559);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle(getString(R.string.bjl));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(79548);
                CreateAvatarUI.this.finish();
                AppMethodBeat.o(79548);
                return true;
            }
        });
        this.appId = getIntent().getStringExtra(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.fileId = getIntent().getStringExtra("default_fileid");
        this.JdQ = (EditText) findViewById(R.id.fzf);
        this.JdQ.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass4 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(79551);
                if (i2 == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                    CreateAvatarUI.this.JdP = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                    if (CreateAvatarUI.this.JdP != null && CreateAvatarUI.this.JdP.isActive()) {
                        CreateAvatarUI.this.JdP.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                        CreateAvatarUI.this.JdQ.setCursorVisible(false);
                        CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                    }
                }
                AppMethodBeat.o(79551);
                return false;
            }
        });
        this.JdQ.setOnKeyListener(new View.OnKeyListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass5 */

            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(79552);
                b bVar = new b();
                bVar.bm(view);
                bVar.pH(i2);
                bVar.bm(keyEvent);
                a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, bVar.axR());
                if (i2 == 4) {
                    CreateAvatarUI.this.JdP = (InputMethodManager) CreateAvatarUI.this.getSystemService("input_method");
                    if (CreateAvatarUI.this.JdP != null && CreateAvatarUI.this.JdP.isActive()) {
                        CreateAvatarUI.this.JdP.hideSoftInputFromWindow(CreateAvatarUI.this.getCurrentFocus().getWindowToken(), 0);
                        CreateAvatarUI.this.JdQ.setCursorVisible(false);
                        CreateAvatarUI.this.getWindow().getDecorView().requestFocus();
                    }
                }
                a.a(false, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$3", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
                AppMethodBeat.o(79552);
                return false;
            }
        });
        this.JdQ.setHintTextColor(getResources().getColor(R.color.uj));
        this.JdQ.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass6 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AppMethodBeat.i(79553);
                if (!CreateAvatarUI.this.JdQ.getText().toString().equals("")) {
                    CreateAvatarUI.this.findViewById(R.id.bi0).setEnabled(true);
                    AppMethodBeat.o(79553);
                    return;
                }
                CreateAvatarUI.this.findViewById(R.id.bi0).setEnabled(false);
                AppMethodBeat.o(79553);
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.JdQ.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass7 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(79554);
                if (motionEvent.getAction() == 0) {
                    CreateAvatarUI.this.JdQ.setCursorVisible(true);
                }
                AppMethodBeat.o(79554);
                return false;
            }
        });
        findViewById(R.id.b11).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass8 */

            public final void onClick(View view) {
                AppMethodBeat.i(79555);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                s.o(CreateAvatarUI.this, 4);
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79555);
            }
        });
        findViewById(R.id.gyk).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(79556);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.this.appId);
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79556);
            }
        });
        findViewById(R.id.gyp).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass10 */

            public final void onClick(View view) {
                AppMethodBeat.i(79557);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CreateAvatarUI.a(CreateAvatarUI.this, CreateAvatarUI.this.appId);
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79557);
            }
        });
        findViewById(R.id.bi0).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(79558);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String obj = CreateAvatarUI.this.JdQ.getText().toString();
                String aqt = com.tencent.mm.n.c.aqt();
                if (Util.isNullOrNil(aqt) || !obj.matches(".*[" + aqt + "].*")) {
                    c.f(CreateAvatarUI.this.JdQ).lv(1, 32).a(CreateAvatarUI.this);
                    a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(79558);
                    return;
                }
                h.c(CreateAvatarUI.this.getContext(), CreateAvatarUI.this.getString(R.string.e3v, new Object[]{aqt}), CreateAvatarUI.this.getString(R.string.zb), true);
                a.a(this, "com/tencent/mm/plugin/webview/ui/tools/CreateAvatarUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(79558);
            }
        });
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("extra_call_by_appbrand", false)) {
            com.tencent.mm.plugin.webview.k.b.INSTANCE.da(4, "");
        }
        AppMethodBeat.o(79559);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(79560);
        super.onResume();
        g.azz().a(2500, this);
        g.azz().a(2785, this);
        g.azz().a(2667, this);
        AppMethodBeat.o(79560);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(79561);
        super.onPause();
        g.azz().b(2500, this);
        g.azz().b(2785, this);
        g.azz().b(2667, this);
        AppMethodBeat.o(79561);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(79562);
        super.onDestroy();
        if (this.gxX != null) {
            this.gxX.dismiss();
        }
        AppMethodBeat.o(79562);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.yo;
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tw(String str) {
        AppMethodBeat.i(79563);
        this.JdW = true;
        if (this.JdT || this.JdU == null || this.JdS) {
            if (this.fileId == null || this.fileId.isEmpty()) {
                Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(BitmapUtil.getBitmapNative((int) R.raw.default_avatar), 500, 500, false);
                String str2 = this.appId;
                byte[] aH = aH(centerCropBitmap);
                Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str2);
                bWL();
                g.azz().a(new com.tencent.mm.plugin.webview.model.i(str2, str, aH), 0);
                this.JdX = System.currentTimeMillis();
                AppMethodBeat.o(79563);
                return;
            }
            bg(this.appId, str, this.fileId);
            AppMethodBeat.o(79563);
        } else if (this.JdU.JBp == c.b.SUCCESS) {
            bg(this.appId, str, this.JdV);
            AppMethodBeat.o(79563);
        } else if (this.JdU.JBp == c.b.FAIL) {
            bWL();
            this.JdU.mm(this.JdR, this.appId);
            AppMethodBeat.o(79563);
        } else {
            bWL();
            AppMethodBeat.o(79563);
        }
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void Tx(String str) {
        AppMethodBeat.i(211039);
        h.n(this, R.string.gqv, R.string.gqy);
        AppMethodBeat.o(211039);
    }

    @Override // com.tencent.mm.ui.tools.b.c.a
    public final void dv(String str) {
        AppMethodBeat.i(164021);
        h.n(this, R.string.gqw, R.string.gqy);
        AppMethodBeat.o(164021);
    }

    private static byte[] aH(Bitmap bitmap) {
        AppMethodBeat.i(79566);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BitmapUtil.compress(bitmap, Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CreateAvatarUI", e2, "", new Object[0]);
        }
        AppMethodBeat.o(79566);
        return byteArray;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(79567);
        Log.i("MicroMsg.CreateAvatarUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            Log.e("MicroMsg.CreateAvatarUI", "Get image from album failed");
            AppMethodBeat.o(79567);
            return;
        }
        switch (i2) {
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(79567);
                    return;
                }
                Intent intent2 = new Intent(this, ImageCropUI.class);
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                p.aYn();
                intent2.putExtra("CropImage_OutputPath", e.M(z.aTY() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", (String) null);
                intent2.putExtra("CropImage_from_scene", 3);
                com.tencent.mm.ui.tools.a.b(this, intent, intent2, d.aSY(), 5, null);
                AppMethodBeat.o(79567);
                return;
            case 5:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        Log.i("MicroMsg.CreateAvatarUI", "onActivityResult(CROP_PICTURE_FOR_AVATAR)  file:%s, size:%d", stringExtra, Long.valueOf(new o(stringExtra).length()));
                        this.JdR = stringExtra;
                        this.JdW = false;
                        this.JdS = false;
                        this.JdT = false;
                        ((ImageView) findViewById(R.id.x8)).setImageBitmap(MMBitmapFactory.decodeFile(stringExtra));
                        if (this.JdU == null) {
                            this.JdU = new com.tencent.mm.plugin.webview.k.c();
                            this.JdU.JBo.observe(this, new Observer<String>() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass2 */

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.arch.lifecycle.Observer
                                public final /* synthetic */ void onChanged(String str) {
                                    AppMethodBeat.i(79549);
                                    Log.i("MicroMsg.CreateAvatarUI", "avatar file id get success = &s", CreateAvatarUI.this.JdV);
                                    CreateAvatarUI.this.JdV = str;
                                    if (CreateAvatarUI.this.JdW) {
                                        com.tencent.mm.ui.tools.b.c.f(CreateAvatarUI.this.JdQ).lv(1, 32).a(CreateAvatarUI.this);
                                    }
                                    AppMethodBeat.o(79549);
                                }
                            });
                        }
                        this.JdV = null;
                        this.JdU.mm(this.JdR, this.appId);
                        break;
                    } else {
                        Log.e("MicroMsg.CreateAvatarUI", "crop picture failed");
                        AppMethodBeat.o(79567);
                        return;
                    }
                } else {
                    AppMethodBeat.o(79567);
                    return;
                }
        }
        AppMethodBeat.o(79567);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r10) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private void bg(String str, String str2, String str3) {
        AppMethodBeat.i(79569);
        Log.i("MicroMsg.CreateAvatarUI", "doAddAvatar appid: %s", str);
        bWL();
        g.azz().a(new com.tencent.mm.plugin.webview.model.i(str, str2, str3), 0);
        this.JdX = System.currentTimeMillis();
        AppMethodBeat.o(79569);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(79570);
        if (qVar instanceof com.tencent.mm.plugin.webview.model.i) {
            Log.i("MicroMsg.CreateAvatarUI", "onAddAvatarEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            gep();
            if (i2 == 0 && i3 == 0) {
                cue cue = ((co) ((com.tencent.mm.plugin.webview.model.i) qVar).rr.iLL.iLR).KGJ;
                Intent intent = new Intent();
                intent.putExtra("id", cue.id);
                intent.putExtra("nickname", cue.nickname);
                intent.putExtra("avatarurl", cue.lHM);
                setResult(-1, intent);
                finish();
            } else if (!agc(i2)) {
                h.c(this, getString(R.string.j1j), getString(R.string.bjd), true);
            } else {
                h.c(this, str, getString(R.string.bjd), true);
            }
            com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(6, (int) (System.currentTimeMillis() - this.JdX), i3);
            AppMethodBeat.o(79570);
        } else if (qVar instanceof com.tencent.mm.plugin.webview.model.p) {
            Log.i("MicroMsg.CreateAvatarUI", "onGetRandomAvatarEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 0) {
                btn btn = (btn) ((com.tencent.mm.plugin.webview.model.p) qVar).rr.iLL.iLR;
                c.a aVar = new c.a();
                aVar.jbq = R.raw.default_avatar;
                aVar.jbx = getResources().getDimension(R.dimen.aid);
                aVar.iaT = true;
                com.tencent.mm.av.q.bcV().a(btn.lHM, (ImageView) findViewById(R.id.x8), aVar.bdv());
                this.JdQ.setText(btn.nickname);
                this.JdT = true;
                this.JdS = false;
                this.fileId = btn.fileid;
                if (!this.JdQ.getText().toString().equals("")) {
                    findViewById(R.id.bi0).setEnabled(true);
                } else {
                    findViewById(R.id.bi0).setEnabled(false);
                }
            } else if (!agc(i2)) {
                h.c(this, getString(R.string.j1j), getString(R.string.bjf), true);
            } else {
                h.c(this, str, getString(R.string.bjf), true);
            }
            com.tencent.mm.plugin.webview.k.b.INSTANCE.aO(5, (int) (System.currentTimeMillis() - this.JdY), i3);
            AppMethodBeat.o(79570);
        } else {
            if (qVar instanceof k) {
                Log.i("MicroMsg.CreateAvatarUI", "onGetCreateAvatarEnd errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (this.JdU == null) {
                    Log.e("MicroMsg.CreateAvatarUI", "uploadEngine == null, multi-Thread Error, thread name = " + Thread.currentThread().getName());
                    AppMethodBeat.o(79570);
                    return;
                }
                com.tencent.mm.plugin.webview.k.c cVar = this.JdU;
                String str2 = ((k) qVar).tjJ;
                if (!str2.equals(cVar.msl)) {
                    Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after onSceneEnd", cVar.msl, str2);
                } else if (i2 == 0 && i3 == 0) {
                    cVar.JBp = c.b.SUCCESS;
                    cm cmVar = (cm) ((k) qVar).rr.iLL.iLR;
                    cVar.JBo.postValue(cmVar.fileid);
                    Log.i("MicroMsg.VestImgUploadEngine", "file id create success: %s", cmVar.fileid);
                } else {
                    cVar.JBp = c.b.FAIL;
                    Log.i("MicroMsg.VestImgUploadEngine", "file id create failed: errType = %s, errCode = %s, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                }
                if (this.JdW) {
                    gep();
                    if (this.JdU.JBp != c.b.SUCCESS) {
                        gep();
                        if (!agc(i2)) {
                            gep();
                            h.c(this, getString(R.string.j1j), getString(R.string.bjd), true);
                            AppMethodBeat.o(79570);
                            return;
                        }
                        h.c(this, str, getString(R.string.bjd), true);
                    }
                }
            }
            AppMethodBeat.o(79570);
        }
    }

    private boolean agc(int i2) {
        AppMethodBeat.i(79571);
        if (i2 == 1 || i2 == 2 || i2 == 7 || i2 == 8) {
            Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, errType = ".concat(String.valueOf(i2)));
            AppMethodBeat.o(79571);
            return false;
        } else if (!NetStatusUtil.isConnected(this)) {
            Log.e("MicroMsg.CreateAvatarUI", "isNetworkAvailable false, not connected");
            AppMethodBeat.o(79571);
            return false;
        } else {
            AppMethodBeat.o(79571);
            return true;
        }
    }

    private void bWL() {
        AppMethodBeat.i(79572);
        if (this.gxX == null || this.gxX.isShowing()) {
            this.gxX = h.a((Context) this, getString(R.string.bjk), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.CreateAvatarUI.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(79550);
                    try {
                        dialogInterface.dismiss();
                        AppMethodBeat.o(79550);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.CreateAvatarUI", "showProgressDlg onCancel exp: %s ", e2.getLocalizedMessage());
                        AppMethodBeat.o(79550);
                    }
                }
            });
            AppMethodBeat.o(79572);
            return;
        }
        this.gxX.show();
        AppMethodBeat.o(79572);
    }

    private void gep() {
        AppMethodBeat.i(79573);
        if (this.gxX == null) {
            AppMethodBeat.o(79573);
            return;
        }
        this.gxX.dismiss();
        AppMethodBeat.o(79573);
    }

    static /* synthetic */ void a(CreateAvatarUI createAvatarUI, String str) {
        AppMethodBeat.i(79574);
        Log.i("MicroMsg.CreateAvatarUI", "doGetRandomAvatar appid: %s", str);
        g.azz().a(new com.tencent.mm.plugin.webview.model.p(str), 0);
        createAvatarUI.JdY = System.currentTimeMillis();
        AppMethodBeat.o(79574);
    }
}
