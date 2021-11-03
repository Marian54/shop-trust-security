resource "azurerm_subnet" "subnet-Team2" {
  name                 = "${var.prefix}-subnet"
  resource_group_name  =  azurerm_resource_group.Resource-Group-Azure-tf-Team2.name
  virtual_network_name = azurerm_virtual_network.vmtf_vnet_Team2.name
  address_prefixes     = ["10.0.2.0/24"]
}
