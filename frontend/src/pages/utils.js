function filterSubArea(array, stringCompare) {
  // console.log(array);
  var copyAux = [];
  for (var i = 0; i < array.length; i++) {
    if (array[i].name == stringCompare) {
      copyAux = array[i].subArea;
    }
  }
  return copyAux;
}
export { filterSubArea };
