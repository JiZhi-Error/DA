package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.h;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae extends m {
    volatile String DDP = "";
    boolean DYJ;
    h EcI;
    boolean Ecz = true;
    private ImageView dKU;
    volatile String imageUrl = "";
    ProgressBar progressBar;

    public ae(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return R.layout.bum;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96693);
        this.dKU = (ImageView) this.contentView.findViewById(R.id.hw1);
        this.progressBar = (ProgressBar) this.contentView.findViewById(R.id.glr);
        if (((t) this.EcX).DYL) {
            Bundle bundle = new Bundle();
            bundle.putString("qrExtInfo", ((t) this.EcX).DYM);
            this.EcI = new h(this.context, fds(), 1, bundle);
            this.dKU.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.AnonymousClass3 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(202995);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    Log.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + ae.this.DDP);
                    boolean jX = ae.this.EcI.jX(ae.this.DDP, ae.this.imageUrl);
                    com.tencent.mm.hellhoundlib.a.a.a(jX, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(202995);
                    return jX;
                }
            });
        }
        AppMethodBeat.o(96693);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96694);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins((int) ((t) this.EcX).paddingLeft, (int) ((t) this.EcX).paddingTop, (int) ((t) this.EcX).paddingRight, (int) ((t) this.EcX).paddingBottom);
            this.contentView.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(96694);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96695);
        if (this.contentView == null || this.dKU == null || this.progressBar == null) {
            AppMethodBeat.o(96695);
        } else if (((t) this.EcX) == null) {
            AppMethodBeat.o(96695);
        } else {
            int i2 = ((t) this.EcX).scaleType;
            if (i2 == 0) {
                this.dKU.setScaleType(ImageView.ScaleType.FIT_XY);
            } else if (i2 == 1) {
                this.dKU.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            Log.i("AdLandingPagePureImageComponet", "cid=" + ((t) this.EcX).DZi + ", scaleType=" + i2);
            this.imageUrl = ((t) this.EcX).DYK;
            String str = ((t) this.EcX).DWN;
            float f2 = ((t) this.EcX).height;
            float f3 = ((t) this.EcX).width;
            this.DYJ = ((t) this.EcX).DYJ;
            if (f2 != 0.0f && f3 != 0.0f && !this.DYJ) {
                int i3 = (this.mEX - ((int) ((t) this.EcX).paddingLeft)) - ((int) ((t) this.EcX).paddingRight);
                if (f3 >= ((float) i3)) {
                    f3 = (float) i3;
                }
                this.dKU.setLayoutParams(new RelativeLayout.LayoutParams((int) f3, (int) ((f3 * ((t) this.EcX).height) / ((t) this.EcX).width)));
            } else if (!this.DYJ || f2 == 0.0f || f3 == 0.0f) {
                this.dKU.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
            } else {
                this.dKU.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, this.mEY));
            }
            if (str != null && str.length() > 0) {
                try {
                    this.dKU.setBackgroundColor(Color.parseColor(str));
                } catch (Exception e2) {
                }
            }
            if (this.imageUrl == null || this.imageUrl.length() <= 0) {
                Log.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                AppMethodBeat.o(96695);
                return;
            }
            Bitmap kD = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kD("adId", this.imageUrl);
            if (kD == null || !ay(kD)) {
                this.Ecz = false;
                startLoading();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.imageUrl, ((t) this.EcX).DZj, new f.a() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWN() {
                        AppMethodBeat.i(96683);
                        ae.this.startLoading();
                        AppMethodBeat.o(96683);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void eWO() {
                        AppMethodBeat.i(96684);
                        ae.this.progressBar.setVisibility(8);
                        AppMethodBeat.o(96684);
                    }

                    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
                    public final void aNH(String str) {
                        AppMethodBeat.i(96685);
                        try {
                            if (ae.a(ae.this).DYK.equals(ae.this.imageUrl)) {
                                ae.this.ay(BitmapUtil.decodeFile(str));
                                ae.this.DDP = str;
                            }
                            AppMethodBeat.o(96685);
                        } catch (Exception e2) {
                            Log.e("AdLandingPagePureImageComponet", "%s" + Util.stackTraceToString(e2));
                            AppMethodBeat.o(96685);
                        }
                    }
                });
            } else {
                Log.i("AdLandingPagePureImageComponet", "loaded cached image with  " + this.imageUrl);
                String kz = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.kz("adId", this.imageUrl);
                if (!TextUtils.isEmpty(kz) && s.YS(kz)) {
                    this.DDP = kz;
                }
                this.Ecz = true;
            }
            if (((t) this.EcX).DYL && ((t) this.EcX).DYN) {
                try {
                    Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl");
                    AdLandingPagesProxy.getInstance().doAdUpdateQrUrlScene("", ((t) this.EcX).DYM, "", fds().uxInfo, fdn(), fds().getSnsId(), new b(this));
                } catch (Throwable th) {
                    Log.e("AdLandingPagePureImageComponet", th.toString());
                }
            }
            final float f4 = ((t) this.EcX).tt;
            if (f4 > 0.0f) {
                Log.i("AdLandingPagePureImageComponet", "fillItem, cornerRadius=" + f4 + ", cId=" + fdn() + ", viewHash=" + this.dKU.hashCode());
                this.dKU.setClipToOutline(true);
                this.dKU.setOutlineProvider(new ViewOutlineProvider() {
                    /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.AnonymousClass2 */

                    public final void getOutline(View view, Outline outline) {
                        AppMethodBeat.i(202994);
                        if (view != null) {
                            Log.d("AdLandingPagePureImageComponet", "getOutline, viewW=" + view.getWidth() + ", vewH=" + view.getHeight());
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f4);
                        }
                        AppMethodBeat.o(202994);
                    }
                });
            }
            AppMethodBeat.o(96695);
        }
    }

    public static class b implements AdLandingPagesProxy.e {
        private WeakReference<ae> EfK;

        b(ae aeVar) {
            AppMethodBeat.i(202999);
            this.EfK = new WeakReference<>(aeVar);
            AppMethodBeat.o(202999);
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void bn(Object obj) {
        }

        @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e
        public final void h(int i2, int i3, Object obj) {
            ae aeVar;
            AppMethodBeat.i(203000);
            if (i2 == 0 && i3 == 0) {
                try {
                    if (obj instanceof byte[]) {
                        btl btl = new btl();
                        btl.parseFrom((byte[]) obj);
                        if (!(this.EfK == null || (aeVar = this.EfK.get()) == null || !aeVar.fdn().equals(btl.Mac))) {
                            Log.i("AdLandingPagePureImageComponet", "request new qr image imgUrl completed");
                            aeVar.imageUrl = btl.url;
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(aeVar.imageUrl, ae.a(aeVar).DZj, new a(aeVar));
                        }
                        AppMethodBeat.o(203000);
                        return;
                    }
                } catch (Throwable th) {
                    Log.e("AdLandingPagePureImageComponet", th.toString());
                    AppMethodBeat.o(203000);
                    return;
                }
            }
            Log.e("AdLandingPagePureImageComponet", "request new qr image imgUrl failed");
            AppMethodBeat.o(203000);
        }
    }

    public static class a implements f.a {
        WeakReference<ae> EfK;

        a(ae aeVar) {
            AppMethodBeat.i(202996);
            this.EfK = new WeakReference<>(aeVar);
            AppMethodBeat.o(202996);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void eWN() {
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void eWO() {
            AppMethodBeat.i(202997);
            Log.e("AdLandingPagePureImageComponet", "there is something error happening when downloading qr image.");
            AppMethodBeat.o(202997);
        }

        @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
        public final void aNH(String str) {
            AppMethodBeat.i(202998);
            ae aeVar = this.EfK.get();
            if (aeVar != null) {
                Log.i("AdLandingPagePureImageComponet", "download qr image completed, the path " + str + "; cId " + aeVar.fdn());
                aeVar.ay(BitmapUtil.decodeFile(str));
                aeVar.DDP = str;
                AppMethodBeat.o(202998);
                return;
            }
            Log.w("AdLandingPagePureImageComponet", "qrCodePureImageComp is null in weak ref");
            AppMethodBeat.o(202998);
        }
    }

    public final void startLoading() {
        AppMethodBeat.i(96696);
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(96696);
    }

    public final boolean ay(Bitmap bitmap) {
        AppMethodBeat.i(96697);
        if (bitmap == null) {
            Log.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            AppMethodBeat.o(96697);
            return false;
        } else if (this.dKU == null) {
            Log.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            AppMethodBeat.o(96697);
            return false;
        } else if (bitmap.getWidth() == 0) {
            Log.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            AppMethodBeat.o(96697);
            return false;
        } else {
            this.dKU.setImageBitmap(bitmap);
            this.progressBar.setVisibility(8);
            AppMethodBeat.o(96697);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96698);
        if (!super.bp(jSONObject)) {
            AppMethodBeat.o(96698);
            return false;
        }
        try {
            if (!this.Ecz) {
                String mD5String = MD5Util.getMD5String(this.imageUrl);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", mD5String);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            AppMethodBeat.o(96698);
            return true;
        } catch (JSONException e2) {
            Log.printErrStackTrace("AdLandingPagePureImageComponet", e2, "", new Object[0]);
            AppMethodBeat.o(96698);
            return false;
        }
    }

    static /* synthetic */ t a(ae aeVar) {
        return (t) aeVar.EcX;
    }
}
