import React from 'react';
import HomePage from './containers/Home'
import LoginPage from './containers/Login'
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom';
import PrivateRoute from './components/PrivateRoute';
import { StoreProvider } from './stores/LoginContext';
import { LoginStore } from './stores/LoginStore';

export default () => (
  <Router>
    <Switch>
      <PrivateRoute path="/" exact>
        <HomePage />
      </PrivateRoute>
      <Route path="/login">
        <StoreProvider value={new LoginStore()}>
          <LoginPage />
        </StoreProvider>
      </Route>
    </Switch>
  </Router>
);
