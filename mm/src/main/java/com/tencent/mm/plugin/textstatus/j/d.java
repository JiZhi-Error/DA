package com.tencent.mm.plugin.textstatus.j;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJR\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J4\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Landroid/graphics/drawable/Drawable;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Landroid/view/View;", "Companion", "plugin-textstatus_release"})
public final class d extends com.tencent.mm.ui.widget.a {
    private static final int Ggg = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    public static final a Ggh = new a((byte) 0);
    private final com.tencent.mm.plugin.textstatus.f.f.a FZq;
    private final a.b VdF;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan$Companion;", "", "()V", "PADDING", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public /* synthetic */ d(Drawable drawable) {
        this(drawable, null, null);
    }

    public d(Drawable drawable, com.tencent.mm.plugin.textstatus.f.f.a aVar, a.b bVar) {
        super(drawable, 1);
        this.FZq = aVar;
        this.VdF = bVar;
    }

    static {
        AppMethodBeat.i(216697);
        AppMethodBeat.o(216697);
    }

    @Override // com.tencent.mm.ui.widget.a
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        AppMethodBeat.i(216695);
        p.h(paint, "paint");
        int size = super.getSize(paint, charSequence, i2, i3, fontMetricsInt) + Ggg;
        AppMethodBeat.o(216695);
        return size;
    }

    @Override // com.tencent.mm.ui.widget.a
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        AppMethodBeat.i(216696);
        p.h(canvas, "canvas");
        p.h(paint, "paint");
        super.draw(canvas, charSequence, i2, i3, f2 + ((float) Ggg), i4, i5, i6, paint);
        AppMethodBeat.o(216696);
    }

    @Override // com.tencent.mm.ui.widget.a
    public final void onClick(View view) {
        AppMethodBeat.i(258536);
        com.tencent.mm.plugin.textstatus.f.f.a aVar = this.FZq;
        a.b bVar = this.VdF;
        if (aVar != null && bVar != null && bVar == a.b.SNS_FEED && p.j(aVar.field_IconID, "2021")) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", aVar.field_UserName);
            c.b(view != null ? view.getContext() : null, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        }
        AppMethodBeat.o(258536);
    }
}
