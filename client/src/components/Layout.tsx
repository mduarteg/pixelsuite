import React, { Fragment } from 'react';
import { Row, Col } from 'antd';

export default function withLayout(WrappedComponent: React.ComponentType<any>) {
  return class ComponentWithLayout extends React.Component {
    render() {
      return (
        <Fragment>
          <Row className="topnav">
            <span className="logo">PixelSuite</span>
          </Row>
          <Row className="body">
            <Col span={24}>
              <WrappedComponent />
            </Col>
          </Row>
        </Fragment>
      );
    }
  }
}
