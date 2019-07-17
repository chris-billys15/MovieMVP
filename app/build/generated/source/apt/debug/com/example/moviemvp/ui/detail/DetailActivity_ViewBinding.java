// Generated code from Butter Knife. Do not modify!
package com.example.moviemvp.ui.detail;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.moviemvp.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailActivity_ViewBinding implements Unbinder {
  private DetailActivity target;

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailActivity_ViewBinding(DetailActivity target, View source) {
    this.target = target;

    target.poster = Utils.findRequiredViewAsType(source, R.id.imageDetail, "field 'poster'", ImageView.class);
    target.movieFavorited = Utils.findRequiredViewAsType(source, R.id.detailFavorite, "field 'movieFavorited'", ImageView.class);
    target.movieTitle = Utils.findRequiredViewAsType(source, R.id.detailName, "field 'movieTitle'", TextView.class);
    target.movieGenre = Utils.findRequiredViewAsType(source, R.id.detailGenre, "field 'movieGenre'", TextView.class);
    target.movieYear = Utils.findRequiredViewAsType(source, R.id.detailYear, "field 'movieYear'", TextView.class);
    target.movieRating = Utils.findRequiredViewAsType(source, R.id.detailRating, "field 'movieRating'", TextView.class);
    target.moviePlot = Utils.findRequiredViewAsType(source, R.id.movie_desc, "field 'moviePlot'", TextView.class);
    target.movieRunTime = Utils.findRequiredViewAsType(source, R.id.detailTime, "field 'movieRunTime'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.poster = null;
    target.movieFavorited = null;
    target.movieTitle = null;
    target.movieGenre = null;
    target.movieYear = null;
    target.movieRating = null;
    target.moviePlot = null;
    target.movieRunTime = null;
    target.toolbar = null;
  }
}
