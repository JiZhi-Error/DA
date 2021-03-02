package com.tencent.mm.ui.matrix.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends a<C2120b> {
    private JSONArray hpw;
    private JSONObject hpx;
    public View.OnLongClickListener tib;

    static /* synthetic */ void a(b bVar, Object obj, JsonItemView jsonItemView, boolean z, int i2) {
        AppMethodBeat.i(38928);
        bVar.a(obj, jsonItemView, z, i2);
        AppMethodBeat.o(38928);
    }

    static /* synthetic */ void a(b bVar, String str, Object obj, JsonItemView jsonItemView, boolean z, int i2) {
        AppMethodBeat.i(38929);
        bVar.a(str, obj, jsonItemView, z, i2);
        AppMethodBeat.o(38929);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(38926);
        JsonItemView jsonItemView = ((C2120b) vVar).Qnn;
        jsonItemView.setTextSize(Qne);
        jsonItemView.setRightColor(Qnd);
        if (this.hpx != null) {
            if (i2 == 0) {
                jsonItemView.gWX();
                jsonItemView.gWY();
                jsonItemView.av("{");
                AppMethodBeat.o(38926);
                return;
            } else if (i2 == getItemCount() - 1) {
                jsonItemView.gWX();
                jsonItemView.gWY();
                jsonItemView.av("}");
                AppMethodBeat.o(38926);
                return;
            } else {
                if (this.hpx.names() != null) {
                    String optString = this.hpx.names().optString(i2 - 1);
                    Object opt = this.hpx.opt(optString);
                    if (i2 < getItemCount() - 2) {
                        a(optString, opt, jsonItemView, true, 1);
                    } else {
                        a(optString, opt, jsonItemView, false, 1);
                    }
                }
                AppMethodBeat.o(38926);
            }
        }
        if (this.hpw != null) {
            if (i2 == 0) {
                jsonItemView.gWX();
                jsonItemView.gWY();
                jsonItemView.av("[");
                AppMethodBeat.o(38926);
                return;
            } else if (i2 == getItemCount() - 1) {
                jsonItemView.gWX();
                jsonItemView.gWY();
                jsonItemView.av("]");
                AppMethodBeat.o(38926);
                return;
            } else {
                Object opt2 = this.hpw.opt(i2 - 1);
                if (i2 < getItemCount() - 2) {
                    a(opt2, jsonItemView, true, 1);
                    AppMethodBeat.o(38926);
                    return;
                }
                a(opt2, jsonItemView, false, 1);
            }
        }
        AppMethodBeat.o(38926);
    }

    public b(JSONArray jSONArray) {
        AppMethodBeat.i(38921);
        this.hpw = jSONArray;
        if (this.hpw == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("jsonArray can not be null.");
            AppMethodBeat.o(38921);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(38921);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(38922);
        if (this.hpx != null) {
            if (this.hpx.names() != null) {
                int length = this.hpx.names().length() + 2;
                AppMethodBeat.o(38922);
                return length;
            }
            AppMethodBeat.o(38922);
            return 2;
        } else if (this.hpw != null) {
            int length2 = this.hpw.length() + 2;
            AppMethodBeat.o(38922);
            return length2;
        } else {
            AppMethodBeat.o(38922);
            return 0;
        }
    }

    private void a(String str, Object obj, JsonItemView jsonItemView, boolean z, int i2) {
        AppMethodBeat.i(38923);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c.aol(i2));
        spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) str).append((CharSequence) "\"").append((CharSequence) ":");
        spannableStringBuilder.setSpan(new ForegroundColorSpan(QmX), 0, spannableStringBuilder.length() - 1, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        jsonItemView.au(spannableStringBuilder);
        b(obj, jsonItemView, z, i2);
        AppMethodBeat.o(38923);
    }

    private void a(Object obj, JsonItemView jsonItemView, boolean z, int i2) {
        AppMethodBeat.i(38924);
        jsonItemView.au(new SpannableStringBuilder(c.aol(i2)));
        b(obj, jsonItemView, z, i2);
        AppMethodBeat.o(38924);
    }

    private void b(Object obj, JsonItemView jsonItemView, boolean z, int i2) {
        AppMethodBeat.i(38925);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (obj instanceof Number) {
            spannableStringBuilder.append((CharSequence) obj.toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(QmZ), 0, spannableStringBuilder.length(), 33);
        } else if (obj instanceof Boolean) {
            spannableStringBuilder.append((CharSequence) obj.toString());
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Qna), 0, spannableStringBuilder.length(), 33);
        } else if (obj instanceof JSONObject) {
            jsonItemView.CE(true);
            spannableStringBuilder.append((CharSequence) "Object{...}");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), 0, spannableStringBuilder.length(), 33);
            jsonItemView.setIconClickListener(new a(this, obj, jsonItemView, z, i2 + 1));
        } else if (obj instanceof JSONArray) {
            jsonItemView.CE(true);
            spannableStringBuilder.append((CharSequence) "Array[").append((CharSequence) String.valueOf(((JSONArray) obj).length())).append((CharSequence) "]");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), 0, 6, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(QmZ), 6, length - 1, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnd), length - 1, length, 33);
            jsonItemView.setIconClickListener(new a(this, obj, jsonItemView, z, i2 + 1));
        } else if (obj != null) {
            jsonItemView.gWY();
            spannableStringBuilder.append((CharSequence) "\"").append((CharSequence) obj.toString()).append((CharSequence) "\"");
            if (c.bnL(obj.toString())) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), 0, 1, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnb), 1, spannableStringBuilder.length() - 1, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(QmY), 0, spannableStringBuilder.length(), 33);
            }
        } else if (spannableStringBuilder.length() == 0 || obj == null) {
            jsonItemView.gWY();
            spannableStringBuilder.append((CharSequence) BuildConfig.COMMAND);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Qnc), 0, spannableStringBuilder.length(), 33);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) ",");
        }
        jsonItemView.av(spannableStringBuilder);
        AppMethodBeat.o(38925);
    }

    /* access modifiers changed from: package-private */
    public class a implements View.OnClickListener {
        private JsonItemView Qnn;
        private boolean Qno;
        private int Qnp;
        private boolean Qnq = true;
        private boolean Qnr;
        final /* synthetic */ b Qns;
        private Object value;

        a(b bVar, Object obj, JsonItemView jsonItemView, boolean z, int i2) {
            boolean z2 = true;
            this.Qns = bVar;
            AppMethodBeat.i(38917);
            this.value = obj;
            this.Qnn = jsonItemView;
            this.Qno = z;
            this.Qnp = i2;
            this.Qnr = (obj == null || !(obj instanceof JSONArray)) ? false : z2;
            AppMethodBeat.o(38917);
        }

        public final void onClick(View view) {
            boolean z = true;
            AppMethodBeat.i(38918);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.Qnn.getChildCount() == 1) {
                this.Qnq = false;
                this.Qnn.CE(false);
                this.Qnn.setTag(this.Qnn.getRightText());
                this.Qnn.av(this.Qnr ? "[" : "{");
                JSONArray names = this.Qnr ? (JSONArray) this.value : ((JSONObject) this.value).names();
                int i2 = 0;
                while (names != null && i2 < names.length()) {
                    JsonItemView jsonItemView = new JsonItemView(this.Qnn.getContext());
                    jsonItemView.setTextSize(a.Qne);
                    jsonItemView.setRightColor(a.Qnd);
                    Object opt = names.opt(i2);
                    if (this.Qnr) {
                        b.a(this.Qns, opt, jsonItemView, i2 < names.length() - 1, this.Qnp);
                    } else {
                        b.a(this.Qns, (String) opt, ((JSONObject) this.value).opt((String) opt), jsonItemView, i2 < names.length() + -1, this.Qnp);
                    }
                    this.Qnn.hm(jsonItemView);
                    i2++;
                }
                JsonItemView jsonItemView2 = new JsonItemView(this.Qnn.getContext());
                jsonItemView2.setTextSize(a.Qne);
                jsonItemView2.setRightColor(a.Qnd);
                StringBuilder sb = new StringBuilder(c.aol(this.Qnp - 1));
                sb.append(this.Qnr ? "]" : "}").append(this.Qno ? "," : "");
                jsonItemView2.av(sb);
                this.Qnn.hm(jsonItemView2);
                this.Qnn.requestLayout();
                this.Qnn.invalidate();
            } else {
                CharSequence rightText = this.Qnn.getRightText();
                this.Qnn.av((CharSequence) this.Qnn.getTag());
                this.Qnn.setTag(rightText);
                this.Qnn.CE(!this.Qnq);
                for (int i3 = 1; i3 < this.Qnn.getChildCount(); i3++) {
                    this.Qnn.getChildAt(i3).setVisibility(this.Qnq ? 0 : 8);
                }
                if (this.Qnq) {
                    z = false;
                }
                this.Qnq = z;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(38918);
        }
    }

    /* renamed from: com.tencent.mm.ui.matrix.recyclerview.b$b  reason: collision with other inner class name */
    class C2120b extends RecyclerView.v {
        JsonItemView Qnn;

        C2120b(final JsonItemView jsonItemView) {
            super(jsonItemView);
            AppMethodBeat.i(38920);
            av(false);
            this.Qnn = jsonItemView;
            jsonItemView.setOnLongClickListener(new View.OnLongClickListener(b.this) {
                /* class com.tencent.mm.ui.matrix.recyclerview.b.C2120b.AnonymousClass1 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(38919);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (b.this.tib != null) {
                        try {
                            jsonItemView.setTag(b.this.hpw.get(C2120b.this.lR() - 1));
                        } catch (Exception e2) {
                        }
                        boolean onLongClick = b.this.tib.onLongClick(view);
                        com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(38919);
                        return onLongClick;
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/matrix/recyclerview/JsonViewerAdapter$JsonItemViewHolder$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(38919);
                    return false;
                }
            });
            AppMethodBeat.o(38920);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(38927);
        C2120b bVar = new C2120b(new JsonItemView(viewGroup.getContext()));
        AppMethodBeat.o(38927);
        return bVar;
    }
}
