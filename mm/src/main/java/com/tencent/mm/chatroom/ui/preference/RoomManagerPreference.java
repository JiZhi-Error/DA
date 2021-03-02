package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class RoomManagerPreference extends Preference {
    private List<as> gwH = new LinkedList();

    public RoomManagerPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(13013);
        AppMethodBeat.o(13013);
    }

    public RoomManagerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(13014);
        AppMethodBeat.o(13014);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(13015);
        super.onBindView(view);
        ((TextView) view.findViewById(R.id.ipm)).setText(getTitle());
        ImageView imageView = (ImageView) view.findViewById(R.id.dt6);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.dt7);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.dt8);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        imageView3.setVisibility(4);
        for (int i2 = 0; i2 < this.gwH.size(); i2++) {
            if (i2 == 0) {
                a.b.a(imageView, this.gwH.get(0).field_username, 0.15f, false);
                imageView.setVisibility(0);
            } else if (1 == i2) {
                a.b.a(imageView2, this.gwH.get(1).field_username, 0.15f, false);
                imageView2.setVisibility(0);
            } else if (2 == i2) {
                imageView3.setVisibility(0);
                a.b.a(imageView3, this.gwH.get(2).field_username, 0.15f, false);
            }
        }
        AppMethodBeat.o(13015);
    }
}
