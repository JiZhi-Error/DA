package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.h;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.widget.a.e;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private boolean PUA;
    private boolean PUB;
    private a PUC;
    private View PUy;
    private String PUz;
    private MMGestureGallery jUy;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI, boolean z) {
        AppMethodBeat.i(37747);
        contactRemarkImagePreviewUI.mD(z);
        AppMethodBeat.o(37747);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37741);
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.PUz = getIntent().getStringExtra("remark_image_path");
        this.PUA = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.PUB = getIntent().getBooleanExtra("view_only", false);
        if (Util.isNullOrNil(this.username)) {
            finish();
            AppMethodBeat.o(37741);
            return;
        }
        initView();
        AppMethodBeat.o(37741);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(37742);
        super.onPause();
        AppMethodBeat.o(37742);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(37743);
        super.onDestroy();
        AppMethodBeat.o(37743);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.y6;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(37744);
        this.PUy = findViewById(R.id.be8);
        this.jUy = (MMGestureGallery) findViewById(R.id.dci);
        setMMTitle(R.string.f2y);
        this.jUy.setVerticalFadingEdgeEnabled(false);
        this.jUy.setHorizontalFadingEdgeEnabled(false);
        ForceGpuUtil.setLayerType(this.jUy);
        this.PUC = new a();
        this.PUC.imagePath = this.PUz;
        this.jUy.setAdapter((SpinnerAdapter) this.PUC);
        this.jUy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(37739);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ContactRemarkImagePreviewUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (!ContactRemarkImagePreviewUI.this.isTitleShowing()) {
                    ContactRemarkImagePreviewUI.this.showTitleView();
                } else {
                    ContactRemarkImagePreviewUI.this.hideTitleView();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ContactRemarkImagePreviewUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37739);
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37737);
                e eVar = new e((Context) ContactRemarkImagePreviewUI.this, 1, false);
                eVar.HLX = new o.f() {
                    /* class com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(m mVar) {
                        AppMethodBeat.i(37735);
                        mVar.d(0, ContactRemarkImagePreviewUI.this.getString(R.string.gau));
                        if (c.aZU("favorite")) {
                            mVar.d(1, ContactRemarkImagePreviewUI.this.getString(R.string.fn9));
                        }
                        if (!ContactRemarkImagePreviewUI.this.PUB) {
                            mVar.d(2, ContactRemarkImagePreviewUI.this.getString(R.string.tf));
                        }
                        AppMethodBeat.o(37735);
                    }
                };
                eVar.HLY = new o.g() {
                    /* class com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.AnonymousClass1.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(37736);
                        switch (menuItem.getItemId()) {
                            case 0:
                                s.l(ContactRemarkImagePreviewUI.this.PUz, ContactRemarkImagePreviewUI.this);
                                AppMethodBeat.o(37736);
                                return;
                            case 1:
                                ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.this);
                                break;
                            case 2:
                                if (!ContactRemarkImagePreviewUI.this.PUA) {
                                    ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                                    AppMethodBeat.o(37736);
                                    return;
                                }
                                new com.tencent.mm.vfs.o(ContactRemarkImagePreviewUI.this.PUz).delete();
                                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                                AppMethodBeat.o(37736);
                                return;
                        }
                        AppMethodBeat.o(37736);
                    }
                };
                eVar.dGm();
                AppMethodBeat.o(37737);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(37738);
                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, false);
                AppMethodBeat.o(37738);
                return false;
            }
        });
        AppMethodBeat.o(37744);
    }

    private void mD(boolean z) {
        AppMethodBeat.i(37745);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
        AppMethodBeat.o(37745);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(37746);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            mD(false);
            AppMethodBeat.o(37746);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(37746);
        return onKeyDown;
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        String imagePath;

        a() {
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i2) {
            return this.imagePath;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(37740);
            View inflate = View.inflate(ContactRemarkImagePreviewUI.this, R.layout.y7, null);
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(R.id.dup);
            inflate.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Bitmap decodeFile = BackwardSupportUtil.BitmapFactory.decodeFile(this.imagePath, com.tencent.mm.cb.a.getDensity(ContactRemarkImagePreviewUI.this));
            if (decodeFile != null) {
                int width = ContactRemarkImagePreviewUI.this.PUy.getWidth();
                int height = ContactRemarkImagePreviewUI.this.PUy.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                float width2 = ((float) decodeFile.getWidth()) / ((float) decodeFile.getHeight());
                float height2 = ((float) decodeFile.getHeight()) / ((float) decodeFile.getWidth());
                Log.v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
                if (height2 >= 2.0f && decodeFile.getHeight() >= 480) {
                    float width3 = ((float) decodeFile.getWidth()) / ((float) width);
                    float width4 = ((float) width) / ((float) decodeFile.getWidth());
                    if (((double) width3) > 1.0d) {
                        matrix.postScale(width4, width4);
                        decodeFile.getHeight();
                        matrix.postTranslate((((float) width) - (width4 * ((float) decodeFile.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        matrix.postTranslate((float) ((width - decodeFile.getWidth()) / 2), 0.0f);
                    }
                } else if (width2 < 2.0f || decodeFile.getWidth() < 480) {
                    float width5 = ((float) width) / ((float) decodeFile.getWidth());
                    float height3 = ((float) height) / ((float) decodeFile.getHeight());
                    if (width5 >= height3) {
                        width5 = height3;
                    }
                    float width6 = ((float) decodeFile.getWidth()) / ((float) width);
                    float height4 = ((float) decodeFile.getHeight()) / ((float) height);
                    if (width6 <= height4) {
                        width6 = height4;
                    }
                    if (((double) width6) > 1.0d) {
                        matrix.postScale(width5, width5);
                    } else {
                        width5 = 1.0f;
                    }
                    matrix.postTranslate((((float) width) - (((float) decodeFile.getWidth()) * width5)) / 2.0f, (((float) height) - (width5 * ((float) decodeFile.getHeight()))) / 2.0f);
                } else {
                    float height5 = ((float) decodeFile.getHeight()) / 480.0f;
                    float height6 = 480.0f / ((float) decodeFile.getHeight());
                    if (((double) height5) > 1.0d) {
                        matrix.postScale(height5, height6);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        float height7 = (float) ((height - decodeFile.getHeight()) / 2);
                        Log.d("MicroMsg.ImagePreviewUI", " offsety ".concat(String.valueOf(height7)));
                        matrix.postTranslate(0.0f, height7);
                    }
                }
                multiTouchImageView.setImageMatrix(matrix);
                multiTouchImageView.cN(decodeFile.getWidth(), decodeFile.getHeight());
                multiTouchImageView.setImageBitmap(decodeFile);
            }
            AppMethodBeat.o(37740);
            return inflate;
        }
    }

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        AppMethodBeat.i(37748);
        cz czVar = new cz();
        h.a(czVar, 6, contactRemarkImagePreviewUI.PUz);
        czVar.dFZ.activity = contactRemarkImagePreviewUI;
        czVar.dFZ.dGf = 46;
        EventCenter.instance.publish(czVar);
        AppMethodBeat.o(37748);
    }
}
