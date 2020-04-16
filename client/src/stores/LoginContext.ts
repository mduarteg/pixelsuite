import { createContext, useContext } from 'react';
import { LoginStore } from './LoginStore';

export const StoreContext = createContext<LoginStore>({} as LoginStore);
export const StoreProvider = StoreContext.Provider;
export const useStore = (): LoginStore => useContext(StoreContext);