import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(items: any[], term: string): any {
    if(term != null && term != ""){
      return items.filter(item => item.nombre.indexOf(term) !== -1);
    }else{
      return items;
    }
    
}

}
