/*
 * Piwigo for Android
 * Copyright (C) 2016-2017 Piwigo Team http://piwigo.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.piwigo.ui.login;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import android.content.Context;

import org.piwigo.accounts.UserManager;
import org.piwigo.io.restrepository.RestUserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LoginViewModelFactory implements ViewModelProvider.Factory {

    private final Context context;
    private final RestUserRepository userRepository;
    private final UserManager userManager;

    @Inject public LoginViewModelFactory(Context context, RestUserRepository userRepository, UserManager userManager) {
        this.userManager = userManager;
        this.context = context;
        this.userRepository = userRepository;
    }

    @Override public <T extends ViewModel> T create(Class<T> viewModelClass) {
        if (viewModelClass.isAssignableFrom(LoginViewModel.class)) {
            //noinspection unchecked
            return (T) new LoginViewModel(userManager, userRepository, context.getResources());
        }
        throw new IllegalStateException("Unable to create " + viewModelClass.getName());
    }
}
