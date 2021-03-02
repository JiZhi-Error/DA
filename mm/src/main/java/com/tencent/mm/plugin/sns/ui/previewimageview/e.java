package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.c;
import com.tencent.mm.plugin.sns.ui.z;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.List;

public final class e implements z {
    private View ARQ;
    private ImageView EHg;
    TextView EqV;
    private boolean FbH;
    c FbI;
    DynamicGridView FbJ;
    z.a FbK;
    float FbL;
    View FbM;
    ImageView FbN;
    private View FbO;
    private int FbP;
    private Rect FbQ;
    private Context context;

    public e(final View view, View view2, View view3, Context context2, final List<String> list, final DynamicGridView dynamicGridView, z.a aVar, c.a aVar2, boolean z) {
        AppMethodBeat.i(100293);
        this.FbH = z;
        this.context = context2;
        this.FbK = aVar;
        this.FbM = view2;
        this.ARQ = view3;
        this.FbJ = dynamicGridView;
        this.FbN = (ImageView) view2.findViewById(R.id.blk);
        this.EqV = (TextView) view2.findViewById(R.id.blo);
        this.FbO = view;
        dynamicGridView.setWobbleInEditMode(false);
        aj.faD();
        this.FbP = ((r.getScreenWidth() - (context2.getResources().getDimensionPixelSize(R.dimen.akd) * 4)) - (context2.getResources().getDimensionPixelSize(R.dimen.hv) * 2)) / 3;
        dynamicGridView.setColumnWidth(this.FbP + (context2.getResources().getDimensionPixelSize(R.dimen.akd) * 2));
        dynamicGridView.setNumColumns(3);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.FbI = new c(context2, list, z, aVar2);
        fkx();
        dynamicGridView.setAdapter((ListAdapter) this.FbI);
        dynamicGridView.setOnDragListener(new DynamicGridView.e() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e
            public final void aai(int i2) {
                AppMethodBeat.i(100280);
                Log.i("DynamicGrid", "drag started at position ".concat(String.valueOf(i2)));
                if (Build.VERSION.SDK_INT >= 21) {
                    e.this.FbL = dynamicGridView.getElevation();
                    dynamicGridView.setElevation(100.0f);
                } else {
                    dynamicGridView.bringToFront();
                }
                e eVar = e.this;
                eVar.FbM.setVisibility(0);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.FbM, "translationY", (float) eVar.FbM.getHeight(), 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.start();
                e.a(e.this);
                AppMethodBeat.o(100280);
            }

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e
            public final void aaj(int i2) {
                AppMethodBeat.i(100281);
                Log.i("DynamicGrid", "drag to del ".concat(String.valueOf(i2)));
                c cVar = e.this.FbI;
                Object item = cVar.getItem(i2);
                cVar.mItems.remove(item);
                cVar.Fbz.remove(item);
                cVar.notifyDataSetChanged();
                if (cVar.FbE != null) {
                    cVar.FbE.removeItem(i2 - cVar.FbA);
                }
                AppMethodBeat.o(100281);
            }

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e
            public final void n(Rect rect) {
                AppMethodBeat.i(100282);
                if (o(rect)) {
                    e eVar = e.this;
                    eVar.FbM.setBackgroundColor(Color.parseColor("#ce3c39"));
                    eVar.FbN.setImageResource(R.raw.sns_img_highlight_delete);
                    eVar.EqV.setText("松手即可删除");
                    AppMethodBeat.o(100282);
                    return;
                }
                e.b(e.this);
                AppMethodBeat.o(100282);
            }

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e
            public final void fky() {
                AppMethodBeat.i(100283);
                e eVar = e.this;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(eVar.FbM, "translationY", 0.0f, (float) eVar.FbM.getHeight());
                ofFloat.setDuration(200L);
                ofFloat.addListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass8 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(100290);
                        e.b(e.this);
                        AppMethodBeat.o(100290);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(100291);
                        e.this.FbM.setVisibility(4);
                        e.this.FbM.setTranslationY(0.0f);
                        AppMethodBeat.o(100291);
                    }

                    public final void onAnimationCancel(Animator animator) {
                        AppMethodBeat.i(100292);
                        e.this.FbM.setVisibility(4);
                        e.this.FbM.setTranslationY(0.0f);
                        AppMethodBeat.o(100292);
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                ofFloat.start();
                e.this.FbI.fkv();
                AppMethodBeat.o(100283);
            }

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.e
            public final boolean o(Rect rect) {
                AppMethodBeat.i(100284);
                boolean a2 = e.a(e.this, rect);
                AppMethodBeat.o(100284);
                return a2;
            }
        });
        dynamicGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass2 */

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                return true;
            }
        });
        dynamicGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass3 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(100285);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (e.this.FbK != null) {
                    if (view.getTag() == null) {
                        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(100285);
                        return;
                    }
                    int intValue = ((Integer) view.getTag()).intValue();
                    Log.i("DynamicGrid", "click ".concat(String.valueOf(intValue)));
                    if (intValue == Integer.MAX_VALUE) {
                        a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(100285);
                        return;
                    }
                    e.this.FbK.Lc(intValue);
                }
                a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(100285);
            }
        });
        dynamicGridView.setOnDropListener(new DynamicGridView.f() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.f
            public final void fkz() {
                AppMethodBeat.i(100286);
                DynamicGridView dynamicGridView = dynamicGridView;
                dynamicGridView.rIC = false;
                dynamicGridView.requestDisallowInterceptTouchEvent(false);
                if (DynamicGridView.fkF() && dynamicGridView.Fcm) {
                    dynamicGridView.vE(true);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    dynamicGridView.setElevation(e.this.FbL);
                    AppMethodBeat.o(100286);
                    return;
                }
                view.bringToFront();
                AppMethodBeat.o(100286);
            }
        });
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass5 */

            public final boolean onPreDraw() {
                AppMethodBeat.i(100287);
                dynamicGridView.getViewTreeObserver().removeOnPreDrawListener(this);
                e.this.aah(list.size());
                AppMethodBeat.o(100287);
                return true;
            }
        });
        aj.faD();
        if (r.getScreenWidth() == 0) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(100288);
                    e.this.aah(list.size());
                    e.this.FbI.notifyDataSetChanged();
                    AppMethodBeat.o(100288);
                }
            }, 50);
        }
        AppMethodBeat.o(100293);
    }

    public final void aah(int i2) {
        int i3 = 3;
        AppMethodBeat.i(100294);
        aj.faD();
        this.FbP = ((r.getScreenWidth() - (this.context.getResources().getDimensionPixelSize(R.dimen.akd) * 4)) - (this.context.getResources().getDimensionPixelSize(R.dimen.hv) * 2)) / 3;
        this.FbJ.setColumnWidth(this.FbP + (this.context.getResources().getDimensionPixelSize(R.dimen.akd) * 2));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.FbJ.getLayoutParams();
        aj.faD();
        Log.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", Integer.valueOf(r.getScreenWidth()));
        int i4 = (i2 + 3) / 3;
        if (i4 <= 3) {
            i3 = i4;
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (this.FbO.getHeight() - this.FbP) - (this.context.getResources().getDimensionPixelSize(R.dimen.akd) * 2), marginLayoutParams.rightMargin, (int) (((float) (4 - i3)) * BitmapUtil.getDefaultDisplayMetrics().density * 32.0f));
        this.FbJ.setLayoutParams(marginLayoutParams);
        AppMethodBeat.o(100294);
    }

    private void fkx() {
        AppMethodBeat.i(100295);
        if (!MMApplicationContext.getDefaultPreference().getBoolean("key_show_tips", true) || this.FbI.fkw() <= 1) {
            this.ARQ.setVisibility(8);
            AppMethodBeat.o(100295);
            return;
        }
        this.ARQ.setVisibility(0);
        this.EHg = (ImageView) this.ARQ.findViewById(R.id.hy_);
        this.EHg.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.previewimageview.e.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(100289);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.a(e.this);
                a.a(this, "com/tencent/mm/plugin/sns/ui/previewimageview/DynamicGridPreviewImgView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100289);
            }
        });
        AppMethodBeat.o(100295);
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void setIsShowAddImage(boolean z) {
        this.FbH = z;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void setImageClick(z.a aVar) {
        this.FbK = aVar;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final View getView() {
        return this.FbJ;
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void setList$22875ea3(List<String> list) {
        AppMethodBeat.i(100296);
        if (this.FbI != null) {
            this.FbI.hl(list);
            fkx();
        }
        AppMethodBeat.o(100296);
    }

    @Override // com.tencent.mm.plugin.sns.ui.z
    public final void clean() {
        AppMethodBeat.i(100297);
        if (this.FbJ != null && this.FbJ.getAdapter() == null) {
            ((c) this.FbJ.getAdapter()).Eva = true;
        }
        AppMethodBeat.o(100297);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(100298);
        eVar.ARQ.setVisibility(8);
        MMApplicationContext.getDefaultPreference().edit().putBoolean("key_show_tips", false).commit();
        AppMethodBeat.o(100298);
    }

    static /* synthetic */ void b(e eVar) {
        AppMethodBeat.i(100299);
        eVar.FbM.setBackgroundColor(Color.parseColor("#e64340"));
        eVar.FbN.setImageResource(R.raw.sns_img_delete);
        eVar.EqV.setText("拖动到此处删除");
        AppMethodBeat.o(100299);
    }

    static /* synthetic */ boolean a(e eVar, Rect rect) {
        AppMethodBeat.i(100300);
        if (rect == null) {
            AppMethodBeat.o(100300);
            return false;
        }
        if (eVar.FbQ == null) {
            eVar.FbQ = new Rect(eVar.FbM.getLeft(), eVar.FbM.getTop(), eVar.FbM.getRight(), eVar.FbM.getBottom());
        }
        Log.d("DynamicGrid", "del area " + eVar.FbQ + ", test rect " + rect);
        boolean intersects = eVar.FbQ.intersects(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(100300);
        return intersects;
    }
}
