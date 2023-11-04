// this was written manually!
// hopefully kotlin/wasm provides this out of the box in the near future
// as of kotlin multiplatform 1.9.20, this is not the case

declare namespace KmpWasmExports {
  function hello(name: string): string;
}

export default KmpWasmExports;
