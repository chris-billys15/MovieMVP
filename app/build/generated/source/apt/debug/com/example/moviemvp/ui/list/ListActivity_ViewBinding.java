// Generated code from Butter Knife. Do not modify!
package com.example.moviemvp.ui.list;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.moviemvp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ListActivity_ViewBinding implements Unbinder {
  private ListActivity target;

  @UiThread
  public ListActivity_ViewBinding(ListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ListActivity_ViewBinding(ListActivity target, View source) {
    this.target = target;

    target.mEditText = Utils.findRequiredViewAsType(source, R.id.searchBar, "field 'mEditText'", EditText.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.listFilm, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEditText = null;
    target.mRecyclerView = null;
  }
}
