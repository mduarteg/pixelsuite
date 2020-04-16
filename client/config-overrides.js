const { override, fixBabelImports, addDecoratorsLegacy, useEslintRc } = require('customize-cra');

module.exports = override(
    addDecoratorsLegacy(),
    useEslintRc('./.eslintrc'),
    fixBabelImports('import', {
      libraryName: 'antd',
      libraryDirectory: 'es',
      style: 'css',
    }),
  );