import React, { ReactNode } from 'react';
import { Route, Redirect } from 'react-router-dom';

const isAuthenticated = false;

function PrivateRoute({ children, ...rest }: { children: ReactNode, path: string, exact: boolean }) {
  return (
    <Route
      {...rest}
      render={({ location }) =>
        isAuthenticated ? (
          children
        ) : (
          <Redirect
            to={{
              pathname: "/login",
              state: { from: location }
            }}
          />
        )
      }
    />
  );
}

export default PrivateRoute;
