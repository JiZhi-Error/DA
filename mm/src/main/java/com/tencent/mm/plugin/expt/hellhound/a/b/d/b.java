package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J.\u0010\f\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FavParamsCatcher;", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/params/IFeedParamCatcher;", "()V", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "Landroid/support/v7/widget/RecyclerView;", "getFeedId", "", "view", "Landroid/view/View;", "position", "", "getFeedInfo", "", "pLikeCount", "Lcom/tencent/mm/pointers/PInt;", "pCommentCount", "getFeedNickName", "getFeedUserName", "getSessionBuffer", "isAd", "", "setRecyclerView", "recyclerView", "Companion", "plugin-expt_release"})
public final class b implements com.tencent.mm.plugin.expt.hellhound.a.a.a.b {
    private static Field sCc;
    private static Field sCd;
    private static Field sCe;
    private static Method sCf;
    private static Method sCg;
    private static Method sCh;
    private static Method sFF;
    private static Field sFG;
    public static final a sGT = new a((byte) 0);
    private WeakReference<RecyclerView> sFA;

    static {
        AppMethodBeat.i(221040);
        AppMethodBeat.o(221040);
    }

    public b() {
        AppMethodBeat.i(221039);
        Log.w("HABBYGE-MALI.FavParamsCatcher", "FavParamsCatcher");
        try {
            Class<?> cls = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter");
            p.g(cls, "Class.forName(WxRecyclerAdapter_Name)");
            Field declaredField = cls.getDeclaredField("data");
            sCc = declaredField;
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            Class<?> cls2 = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
            p.g(cls2, "Class.forName(FinderMediaBannerAdapter_Name)");
            Field declaredField2 = cls2.getDeclaredField("feed");
            sCd = declaredField2;
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Class<?> cls3 = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed");
            p.g(cls3, "Class.forName(BaseFinderFeed_Name)");
            Field declaredField3 = cls3.getDeclaredField("feedObject");
            sCe = declaredField3;
            if (declaredField3 != null) {
                declaredField3.setAccessible(true);
            }
            Class<?> cls4 = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
            p.g(cls4, "Class.forName(FinderItem_Name)");
            Method declaredMethod = cls4.getDeclaredMethod("getId", new Class[0]);
            sCf = declaredMethod;
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
            }
            Method declaredMethod2 = cls4.getDeclaredMethod("getUserName", new Class[0]);
            sCg = declaredMethod2;
            if (declaredMethod2 != null) {
                declaredMethod2.setAccessible(true);
            }
            Method declaredMethod3 = cls4.getDeclaredMethod("getNickName", new Class[0]);
            sCh = declaredMethod3;
            if (declaredMethod3 != null) {
                declaredMethod3.setAccessible(true);
            }
            Method declaredMethod4 = cls4.getDeclaredMethod("getFinderObject", new Class[0]);
            p.g(declaredMethod4, "FinderItem_Class.getDecl…FinderObject_Method_Name)");
            sFF = declaredMethod4;
            if (declaredMethod4 == null) {
                p.btv("getFinderObject_Method");
            }
            declaredMethod4.setAccessible(true);
            Class<?> cls5 = Class.forName("com.tencent.mm.protocal.protobuf.FinderObject");
            p.g(cls5, "Class.forName(FinderObject_Name)");
            Field declaredField4 = cls5.getDeclaredField("sessionBuffer");
            p.g(declaredField4, "FinderObject_Class.getDe…sessionBuffer_Field_Name)");
            sFG = declaredField4;
            if (declaredField4 == null) {
                p.btv("sessionBuffer_Field");
            }
            declaredField4.setAccessible(true);
            AppMethodBeat.o(221039);
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e2, "reflect crash: %s", e2.getMessage());
            AppMethodBeat.o(221039);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FavParamsCatcher$Companion;", "", "()V", "BaseFinderFeed_Name", "", "FinderItem_Name", "FinderMediaBannerAdapter_Name", "FinderObject_Name", "TAG", "WxRecyclerAdapter_Name", "data_Field_Name", "data_field", "Ljava/lang/reflect/Field;", "feedObject_Field", "feedObject_Field_Name", "feed_Field_Name", "feed_field", "getFinderObject_Method", "Ljava/lang/reflect/Method;", "getFinderObject_Method_Name", "getId_Method", "getId_Method_Name", "getNickName_Method", "getUserName_Method", "nickName_Method_Name", "sessionBuffer_Field", "sessionBuffer_Field_Name", "userName_Method_Name", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ac(View view, int i2) {
        RecyclerView.a adapter;
        Object obj;
        Object obj2;
        Object obj3;
        AppMethodBeat.i(221034);
        if (this.sFA != null) {
            WeakReference<RecyclerView> weakReference = this.sFA;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                if (adapter instanceof WxRecyclerAdapter) {
                    try {
                        Field field = sCc;
                        if (field != null) {
                            obj2 = field.get(adapter);
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            AppMethodBeat.o(221034);
                            return null;
                        }
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList.isEmpty() || i2 < 0 || i2 >= arrayList.size()) {
                            AppMethodBeat.o(221034);
                            return null;
                        }
                        Object obj4 = arrayList.get(i2);
                        if (obj4 == null) {
                            AppMethodBeat.o(221034);
                            return null;
                        }
                        Field field2 = sCe;
                        Object obj5 = field2 != null ? field2.get(obj4) : null;
                        Method method = sCf;
                        if (method != null) {
                            obj3 = method.invoke(obj5, new Object[0]);
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.Long");
                            AppMethodBeat.o(221034);
                            throw tVar;
                        }
                        String zs = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long) obj3).longValue());
                        AppMethodBeat.o(221034);
                        return zs;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e2, "_getFeedId, e2, crash: " + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(221034);
                        return null;
                    }
                } else if (adapter instanceof com.tencent.mm.ui.base.a.a) {
                    try {
                        Field field3 = sCd;
                        if (field3 != null) {
                            obj = field3.get(adapter);
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            AppMethodBeat.o(221034);
                            return null;
                        }
                        Method method2 = sCf;
                        Object invoke = method2 != null ? method2.invoke(obj, new Object[0]) : null;
                        if (invoke == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.Long");
                            AppMethodBeat.o(221034);
                            throw tVar2;
                        }
                        String zs2 = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long) invoke).longValue());
                        AppMethodBeat.o(221034);
                        return zs2;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e3, "_getFeedId, e1, crash: " + e3.getMessage(), new Object[0]);
                        AppMethodBeat.o(221034);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(221034);
                    return null;
                }
            }
        }
        AppMethodBeat.o(221034);
        return null;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final void a(View view, PInt pInt, PInt pInt2, int i2) {
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ad(View view, int i2) {
        RecyclerView.a adapter;
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        Object obj4;
        AppMethodBeat.i(221035);
        if (this.sFA != null) {
            WeakReference<RecyclerView> weakReference = this.sFA;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                if (adapter instanceof WxRecyclerAdapter) {
                    try {
                        Field field = sCc;
                        if (field != null) {
                            obj3 = field.get(adapter);
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            AppMethodBeat.o(221035);
                            return null;
                        }
                        if (obj3 instanceof ArrayList) {
                            if (!((Collection) obj3).isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && i2 >= 0 && i2 < ((ArrayList) obj3).size()) {
                                Object obj5 = ((ArrayList) obj3).get(i2);
                                if (obj5 == null) {
                                    AppMethodBeat.o(221035);
                                    return null;
                                }
                                Field field2 = sCe;
                                Object obj6 = field2 != null ? field2.get(obj5) : null;
                                Method method = sCg;
                                if (method != null) {
                                    obj4 = method.invoke(obj6, new Object[0]);
                                } else {
                                    obj4 = null;
                                }
                                if (obj4 == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                                    AppMethodBeat.o(221035);
                                    throw tVar;
                                }
                                String str = (String) obj4;
                                AppMethodBeat.o(221035);
                                return str;
                            }
                        }
                        AppMethodBeat.o(221035);
                        return null;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e2, "getFeedUserName e1: " + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(221035);
                        return null;
                    }
                } else if (adapter instanceof com.tencent.mm.ui.base.a.a) {
                    try {
                        Field field3 = sCd;
                        if (field3 != null) {
                            obj = field3.get(adapter);
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            AppMethodBeat.o(221035);
                            return null;
                        }
                        Method method2 = sCg;
                        if (method2 != null) {
                            obj2 = method2.invoke(obj, new Object[0]);
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                            AppMethodBeat.o(221035);
                            throw tVar2;
                        }
                        String str2 = (String) obj2;
                        AppMethodBeat.o(221035);
                        return str2;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e3, "getFeedUserName e2: " + e3.getMessage(), new Object[0]);
                        AppMethodBeat.o(221035);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(221035);
                    return null;
                }
            }
        }
        AppMethodBeat.o(221035);
        return null;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String ae(View view, int i2) {
        RecyclerView.a adapter;
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        Object obj4;
        AppMethodBeat.i(221036);
        if (this.sFA != null) {
            WeakReference<RecyclerView> weakReference = this.sFA;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                if (adapter instanceof WxRecyclerAdapter) {
                    try {
                        Field field = sCc;
                        if (field != null) {
                            obj3 = field.get(adapter);
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            AppMethodBeat.o(221036);
                            return null;
                        }
                        if (obj3 instanceof ArrayList) {
                            if (!((Collection) obj3).isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && i2 >= 0 && i2 < ((ArrayList) obj3).size()) {
                                Object obj5 = ((ArrayList) obj3).get(i2);
                                if (obj5 == null) {
                                    AppMethodBeat.o(221036);
                                    return null;
                                }
                                Field field2 = sCe;
                                Object obj6 = field2 != null ? field2.get(obj5) : null;
                                Method method = sCh;
                                if (method != null) {
                                    obj4 = method.invoke(obj6, new Object[0]);
                                } else {
                                    obj4 = null;
                                }
                                if (obj4 == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                                    AppMethodBeat.o(221036);
                                    throw tVar;
                                }
                                String str = (String) obj4;
                                AppMethodBeat.o(221036);
                                return str;
                            }
                        }
                        AppMethodBeat.o(221036);
                        return null;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e2, "getFeedNickName e1: " + e2.getMessage(), new Object[0]);
                        AppMethodBeat.o(221036);
                        return null;
                    }
                } else if (adapter instanceof com.tencent.mm.ui.base.a.a) {
                    try {
                        Field field3 = sCd;
                        if (field3 != null) {
                            obj = field3.get(adapter);
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            AppMethodBeat.o(221036);
                            return null;
                        }
                        Method method2 = sCh;
                        if (method2 != null) {
                            obj2 = method2.invoke(obj, new Object[0]);
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                            AppMethodBeat.o(221036);
                            throw tVar2;
                        }
                        String str2 = (String) obj2;
                        AppMethodBeat.o(221036);
                        return str2;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e3, "getFeedNickName e2: " + e3.getMessage(), new Object[0]);
                        AppMethodBeat.o(221036);
                        return null;
                    }
                } else {
                    AppMethodBeat.o(221036);
                    return null;
                }
            }
        }
        AppMethodBeat.o(221036);
        return null;
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final boolean dP(View view) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if ((r0 != null ? r0.get() : null) == null) goto L_0x001c;
     */
    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRecyclerView(android.support.v7.widget.RecyclerView r3) {
        /*
            r2 = this;
            r1 = 221037(0x35f6d, float:3.09739E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r1)
            if (r3 != 0) goto L_0x000c
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
        L_0x000b:
            return
        L_0x000c:
            java.lang.ref.WeakReference<android.support.v7.widget.RecyclerView> r0 = r2.sFA
            if (r0 == 0) goto L_0x001c
            java.lang.ref.WeakReference<android.support.v7.widget.RecyclerView> r0 = r2.sFA
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r0.get()
            android.support.v7.widget.RecyclerView r0 = (android.support.v7.widget.RecyclerView) r0
        L_0x001a:
            if (r0 != 0) goto L_0x0023
        L_0x001c:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r0.<init>(r3)
            r2.sFA = r0
        L_0x0023:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r1)
            goto L_0x000b
        L_0x0027:
            r0 = 0
            goto L_0x001a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.b.d.b.setRecyclerView(android.support.v7.widget.RecyclerView):void");
    }

    @Override // com.tencent.mm.plugin.expt.hellhound.a.a.a.b
    public final String GY(int i2) {
        RecyclerView.a adapter;
        Object obj;
        Object obj2;
        boolean z;
        AppMethodBeat.i(221038);
        if (this.sFA != null) {
            WeakReference<RecyclerView> weakReference = this.sFA;
            RecyclerView recyclerView = weakReference != null ? weakReference.get() : null;
            if (!(recyclerView == null || (adapter = recyclerView.getAdapter()) == null)) {
                if (adapter instanceof WxRecyclerAdapter) {
                    try {
                        Field field = sCc;
                        if (field != null) {
                            obj2 = field.get(adapter);
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            AppMethodBeat.o(221038);
                            return null;
                        }
                        if (obj2 instanceof ArrayList) {
                            if (!((Collection) obj2).isEmpty()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && i2 >= 0 && i2 < ((ArrayList) obj2).size()) {
                                Object obj3 = ((ArrayList) obj2).get(i2);
                                if (obj3 == null) {
                                    AppMethodBeat.o(221038);
                                    return null;
                                }
                                Field field2 = sCe;
                                Object obj4 = field2 != null ? field2.get(obj3) : null;
                                Method method = sFF;
                                if (method == null) {
                                    p.btv("getFinderObject_Method");
                                }
                                Object invoke = method.invoke(obj4, new Object[0]);
                                Field field3 = sFG;
                                if (field3 == null) {
                                    p.btv("sessionBuffer_Field");
                                }
                                Object obj5 = field3.get(invoke);
                                if (obj5 == null) {
                                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                                    AppMethodBeat.o(221038);
                                    throw tVar;
                                }
                                String str = (String) obj5;
                                AppMethodBeat.o(221038);
                                return str;
                            }
                        }
                        AppMethodBeat.o(221038);
                        return null;
                    } catch (Exception e2) {
                        try {
                            Field field4 = sCd;
                            if (field4 != null) {
                                obj = field4.get(adapter);
                            } else {
                                obj = null;
                            }
                            if (obj == null) {
                                AppMethodBeat.o(221038);
                                return null;
                            }
                            Method method2 = sFF;
                            if (method2 == null) {
                                p.btv("getFinderObject_Method");
                            }
                            Object invoke2 = method2.invoke(obj, new Object[0]);
                            Field field5 = sFG;
                            if (field5 == null) {
                                p.btv("sessionBuffer_Field");
                            }
                            Object obj6 = field5.get(invoke2);
                            if (obj6 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
                                AppMethodBeat.o(221038);
                                throw tVar2;
                            }
                            String str2 = (String) obj6;
                            AppMethodBeat.o(221038);
                            return str2;
                        } catch (Exception e3) {
                            Log.printErrStackTrace("HABBYGE-MALI.FavParamsCatcher", e3, "getSessionBuffer crash: " + e3.getMessage(), new Object[0]);
                            AppMethodBeat.o(221038);
                            return null;
                        }
                    }
                } else {
                    AppMethodBeat.o(221038);
                    return null;
                }
            }
        }
        AppMethodBeat.o(221038);
        return null;
    }
}
