import { observable, action, computed } from 'mobx';

export class LoginStore {
    @observable currentCount: number = 1;

    @action
    sumOne = (): void => {
      this.currentCount++;
    }

    @action
    minOne = (): void => {
      this.currentCount--;
    }

    @action
    reset = (): void => {
      this.currentCount = 0;
    }

    @computed get currentIs() {
      return `Current count is ${this.currentCount}`
    }
}
