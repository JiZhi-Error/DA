package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.c;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    private String BqZ;
    private List<String> Bwp = new ArrayList();
    private Context context;

    public MailAttachListLinearLayout(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        AppMethodBeat.i(123105);
        this.context = context2;
        AppMethodBeat.o(123105);
    }

    public void setMailId(String str) {
        this.BqZ = str;
    }

    public final void fY(List<Bundle> list) {
        AppMethodBeat.i(198719);
        for (int i2 = 0; i2 < list.size(); i2++) {
            View inflate = View.inflate(this.context, R.layout.bl4, null);
            Bundle bundle = list.get(i2);
            if (i2 == list.size() - 1) {
                inflate.setBackgroundResource(R.drawable.agj);
            } else {
                inflate.setBackgroundResource(R.drawable.agi);
            }
            addView(inflate);
            final String string = bundle.getString("attach_name", "");
            this.Bwp.add(string);
            final int i3 = bundle.getInt("attach_size", 0);
            ((TextView) inflate.findViewById(R.id.gt8)).setText(string);
            ((TextView) inflate.findViewById(R.id.gt_)).setText(Util.getSizeKB((long) i3));
            final String string2 = bundle.getString("attach_fileId", "");
            final String string3 = bundle.getString("attach_download_url", "");
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(123104);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent(MailAttachListLinearLayout.this.context, AttachDownloadPage.class);
                    intent.putExtra("attach_name", string);
                    intent.putExtra("mail_id", MailAttachListLinearLayout.this.BqZ);
                    intent.putExtra("attach_id", string2);
                    intent.putExtra("total_size", i3);
                    intent.putExtra("attach_url", string3);
                    intent.putExtra("is_compress", MailAttachListLinearLayout.aKL(string3));
                    intent.putExtra("is_preview", 1);
                    intent.putExtra("qqmail_cookie", c.hsp().getCookie(v.eGq()));
                    Context context = MailAttachListLinearLayout.this.context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(context, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAttachListLinearLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(123104);
                }
            });
            ((ImageView) inflate.findViewById(R.id.gt7)).setImageResource(FileExplorerUI.bfq(string));
        }
        AppMethodBeat.o(198719);
    }

    static /* synthetic */ boolean aKL(String str) {
        AppMethodBeat.i(198720);
        if (str == null || !str.contains("/cgi-bin/viewcompress")) {
            AppMethodBeat.o(198720);
            return false;
        }
        AppMethodBeat.o(198720);
        return true;
    }
}
