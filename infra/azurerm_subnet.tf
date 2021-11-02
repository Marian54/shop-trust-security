resource "azurerm_subnet" "subnet" {
  name                 = "${var.prefix}-subnet"
  resource_group_name  =  azurerm_resource_group.rg-azure-tf.name
  virtual_network_name = azurerm_virtual_network.vmtf_vnet.name
  address_prefixes     = ["10.0.2.0/24"]
}
