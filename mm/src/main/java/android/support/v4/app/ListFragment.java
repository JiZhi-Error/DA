package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ListFragment extends Fragment {
    private final Runnable GM = new Runnable() {
        /* class android.support.v4.app.ListFragment.AnonymousClass1 */

        public final void run() {
            ListFragment.this.GP.focusableViewAvailable(ListFragment.this.GP);
        }
    };
    private final AdapterView.OnItemClickListener GN = new AdapterView.OnItemClickListener() {
        /* class android.support.v4.app.ListFragment.AnonymousClass2 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        }
    };
    ListAdapter GO;
    ListView GP;
    View GQ;
    TextView GR;
    View GS;
    View GT;
    boolean GU;
    CharSequence mEmptyText;
    private final Handler mHandler = new Handler();

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = getContext();
        FrameLayout frameLayout = new FrameLayout(context);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(context, null, 16842874), new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(16711683);
        TextView textView = new TextView(context);
        textView.setId(16711681);
        textView.setGravity(17);
        frameLayout2.addView(textView, new FrameLayout.LayoutParams(-1, -1));
        ListView listView = new ListView(context);
        listView.setId(16908298);
        listView.setDrawSelectorOnTop(false);
        frameLayout2.addView(listView, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ep();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        this.mHandler.removeCallbacks(this.GM);
        this.GP = null;
        this.GU = false;
        this.GT = null;
        this.GS = null;
        this.GQ = null;
        this.GR = null;
        super.onDestroyView();
    }

    private void setListAdapter(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.GO != null;
        this.GO = listAdapter;
        if (this.GP != null) {
            this.GP.setAdapter(listAdapter);
            if (!this.GU && !z2) {
                if (getView().getWindowToken() != null) {
                    z = true;
                }
                e(true, z);
            }
        }
    }

    private void e(boolean z, boolean z2) {
        ep();
        if (this.GS == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.GU != z) {
            this.GU = z;
            if (z) {
                if (z2) {
                    this.GS.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.GT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    this.GS.clearAnimation();
                    this.GT.clearAnimation();
                }
                this.GS.setVisibility(8);
                this.GT.setVisibility(0);
                return;
            }
            if (z2) {
                this.GS.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.GT.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                this.GS.clearAnimation();
                this.GT.clearAnimation();
            }
            this.GS.setVisibility(0);
            this.GT.setVisibility(8);
        }
    }

    private void ep() {
        if (this.GP == null) {
            View view = getView();
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.GP = (ListView) view;
            } else {
                this.GR = (TextView) view.findViewById(16711681);
                if (this.GR == null) {
                    this.GQ = view.findViewById(16908292);
                } else {
                    this.GR.setVisibility(8);
                }
                this.GS = view.findViewById(16711682);
                this.GT = view.findViewById(16711683);
                View findViewById = view.findViewById(16908298);
                if (findViewById instanceof ListView) {
                    this.GP = (ListView) findViewById;
                    if (this.GQ != null) {
                        this.GP.setEmptyView(this.GQ);
                    } else if (this.mEmptyText != null) {
                        this.GR.setText(this.mEmptyText);
                        this.GP.setEmptyView(this.GR);
                    }
                } else if (findViewById == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.GU = true;
            this.GP.setOnItemClickListener(this.GN);
            if (this.GO != null) {
                ListAdapter listAdapter = this.GO;
                this.GO = null;
                setListAdapter(listAdapter);
            } else if (this.GS != null) {
                e(false, false);
            }
            this.mHandler.post(this.GM);
        }
    }
}
