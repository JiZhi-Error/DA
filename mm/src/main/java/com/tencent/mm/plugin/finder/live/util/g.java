package com.tencent.mm.plugin.finder.live.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.x;

public final class g {
    private static final String TAG = TAG;
    private static final LruCache<String, Bitmap> uwc = new LruCache<>(5);
    public static final g uwd = new g();

    public static final class a<T, R> implements e<o, Bitmap> {
        final /* synthetic */ b $next;
        final /* synthetic */ View hCI;
        final /* synthetic */ String toX;

        a(View view, String str, b bVar) {
            this.hCI = view;
            this.toX = str;
            this.$next = bVar;
        }

        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(247236);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                m mVar = m.vVH;
                m.a(this.hCI, bitmap2, new b<Bitmap, x>(this) {
                    /* class com.tencent.mm.plugin.finder.live.util.g.a.AnonymousClass1 */
                    final /* synthetic */ a uwe;

                    {
                        this.uwe = r2;
                    }

                    @Override // kotlin.g.a.b
                    public final /* synthetic */ x invoke(Bitmap bitmap) {
                        AppMethodBeat.i(247235);
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 != null) {
                            g gVar = g.uwd;
                            g.uwc.put(this.uwe.toX, bitmap2);
                            new Canvas(bitmap2).drawColor(1711276032);
                            b bVar = this.uwe.$next;
                            if (bVar != null) {
                                bVar.invoke(Boolean.TRUE);
                            }
                        } else {
                            b bVar2 = this.uwe.$next;
                            if (bVar2 != null) {
                                bVar2.invoke(Boolean.FALSE);
                            }
                        }
                        x xVar = x.SXb;
                        AppMethodBeat.o(247235);
                        return xVar;
                    }
                });
                AppMethodBeat.o(247236);
                return;
            }
            g gVar2 = g.uwd;
            Log.i(g.getTAG(), "loadAvatarBlurBg resource is null!");
            b bVar = this.$next;
            if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
                AppMethodBeat.o(247236);
                return;
            }
            AppMethodBeat.o(247236);
        }
    }

    static {
        AppMethodBeat.i(247239);
        AppMethodBeat.o(247239);
    }

    private g() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static /* synthetic */ void a(String str, String str2, View view) {
        AppMethodBeat.i(247238);
        a(str, str2, view, null);
        AppMethodBeat.o(247238);
    }

    public static void a(String str, String str2, View view, b<? super Boolean, x> bVar) {
        Bitmap bitmap;
        boolean z;
        String str3;
        boolean z2;
        String str4;
        String str5;
        boolean z3;
        AppMethodBeat.i(247237);
        p.h(str2, "liveCoverUrl");
        p.h(view, "view");
        if (str == null) {
            Log.i(TAG, "loadAvatarBlurBg anchorUsername is null!");
            if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
                AppMethodBeat.o(247237);
                return;
            }
            AppMethodBeat.o(247237);
            return;
        }
        synchronized (uwc) {
            try {
                bitmap = uwc.get(str);
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(247237);
                throw th;
            }
        }
        if (bitmap == null) {
            if (str2.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                c.a aVar = c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str);
                if (!(asG == null || (str5 = asG.field_liveCoverImg) == null)) {
                    String str6 = str5;
                    if (str6 == null || str6.length() == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        str4 = asG.field_avatarUrl;
                        p.g(str4, "contact?.field_avatarUrl");
                        str3 = str4;
                    }
                }
                str4 = String.valueOf(asG != null ? asG.field_liveCoverImg : null);
                str3 = str4;
            } else {
                str3 = str2;
            }
            Log.i(TAG, "loadAvatarBlurBg anchorUsername:" + str + ",coverUrl:" + str3 + '!');
            String str7 = str3;
            if (str7 == null || str7.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.plugin.finder.loader.m.djY().bQ(new com.tencent.mm.plugin.finder.loader.a(str3)).a(new a(view, str, bVar)).vC();
                AppMethodBeat.o(247237);
            } else if (bVar != null) {
                bVar.invoke(Boolean.FALSE);
                AppMethodBeat.o(247237);
            } else {
                AppMethodBeat.o(247237);
            }
        } else {
            Log.i(TAG, "loadAvatarBlurBg from cache anchorUsername:" + str + '!');
            if (view instanceof ImageView) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                ((ImageView) view).setImageDrawable(new BitmapDrawable(context.getResources(), bitmap));
            } else {
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                view.setBackground(new BitmapDrawable(context2.getResources(), bitmap));
            }
            if (bVar != null) {
                bVar.invoke(Boolean.TRUE);
                AppMethodBeat.o(247237);
                return;
            }
            AppMethodBeat.o(247237);
        }
    }
}
