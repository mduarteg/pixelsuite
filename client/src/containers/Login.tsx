import React from 'react';
import { Row, Col } from 'antd';
import { useObserver } from 'mobx-react';
import LoginForm from '../components/LoginForm';
import withLayout from '../components/Layout';
import { useStore } from '../stores/LoginContext';

const Login = () => {
  const loginStore = useStore();

  return useObserver(() => (
    <Row type="flex" justify="space-around" align="middle">
      <Col span={8}>
        <LoginForm />
      </Col>
    </Row>
  ));
}

export default withLayout(Login);
